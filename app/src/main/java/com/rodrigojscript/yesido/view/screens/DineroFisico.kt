package com.rodrigojscript.yesido.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rodrigojscript.yesido.R
import com.rodrigojscript.yesido.model.database.SaldoDia
import com.rodrigojscript.yesido.view.components.CustomCardFisico
import com.rodrigojscript.yesido.view.theme.BaseAppTheme
import com.rodrigojscript.yesido.viewmodel.YesViewModel
import java.text.SimpleDateFormat
import java.util.*

var dineroFisico: Double = 0.0

@Composable
fun DineroFisico(navController: NavController, yesViewModel: YesViewModel) {
    @SuppressLint("SimpleDateFormat")
    val sdf = SimpleDateFormat("dd/M/yyyy")
    val currentDate: String = sdf.format(Date())
    var numberMil by rememberSaveable { mutableStateOf("") }
    var numberQui by rememberSaveable { mutableStateOf("") }
    var numberDoc by rememberSaveable { mutableStateOf("") }
    var numberCie by rememberSaveable { mutableStateOf("") }
    var numberCin by rememberSaveable { mutableStateOf("") }
    var numberVei by rememberSaveable { mutableStateOf("") }
    var numberDie by rememberSaveable { mutableStateOf("") }
    var numberCco by rememberSaveable { mutableStateOf("") }
    var numberDos by rememberSaveable { mutableStateOf("") }
    var numberUno by rememberSaveable { mutableStateOf("") }
    var numberCen by rememberSaveable { mutableStateOf("") }
    var dineroFisicoTotal by remember { mutableStateOf("0.0") }
    var dineroTotal by remember { mutableStateOf("0.1") }
    BaseAppTheme {
        Scaffold(topBar = {
            TopAppBar(
                title = { Text(text = "Dinero fisico") }, navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        },

                        ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }, content = { innerPaddings ->
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        innerPaddings
                    )
            ) {
                item {
                    CustomCardFisico(nmb = numberMil, image = R.drawable.mil) {
                        numberMil = it
                    }
                    CustomCardFisico(nmb = numberQui, image = R.drawable.qui) {
                        numberQui = it
                    }
                    CustomCardFisico(nmb = numberDoc, image = R.drawable.doc) {
                        numberDoc = it
                    }
                    CustomCardFisico(nmb = numberCie, image = R.drawable.cien) {
                        numberCie = it
                    }
                    CustomCardFisico(nmb = numberCin, image = R.drawable.cin) {
                        numberCin = it
                    }
                    CustomCardFisico(nmb = numberVei, image = R.drawable.vei) {
                        numberVei = it
                    }
                    CustomCardFisico(nmb = numberDie, image = R.drawable.die) {
                        numberDie = it
                    }
                    CustomCardFisico(nmb = numberCco, image = R.drawable.cco) {
                        numberCco = it
                    }
                    CustomCardFisico(nmb = numberDos, image = R.drawable.dos) {
                        numberDos = it
                    }
                    CustomCardFisico(nmb = numberUno, image = R.drawable.uno) {
                        numberUno = it
                    }
                    CustomCardFisico(nmb = numberCen, image = R.drawable.cen) {
                        numberCen = it
                    }
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(modifier = Modifier.padding(end = 8.dp), onClick = {
                            yesViewModel.calcularDF(
                                nMil = numberMil,
                                nQui = numberQui,
                                nDoc = numberDoc,
                                nCie = numberCie,
                                nCin = numberCin,
                                nVei = numberVei,
                                nDie = numberDie,
                                nCco = numberCco,
                                nDos = numberDos,
                                nUno = numberUno,
                                nCen = numberCen
                            )
                            dineroFisicoTotal = dineroFisico.toString()
                            dineroTotal = (dineroFisico - dineroNotas).toString()
                        }) {
                            Text(text = "Suma", fontSize = 20.sp)
                        }
                        Button(modifier = Modifier.padding(start = 8.dp), onClick = {
                            numberMil = ""
                            numberQui = ""
                            numberDoc = ""
                            numberCie = ""
                            numberCin = ""
                            numberVei = ""
                            numberDie = ""
                            numberCco = ""
                            numberDos = ""
                            numberUno = ""
                            numberCen = ""
                            dineroFisicoTotal = "0"
                            dineroTotal = "0"
                        }) {
                            Text(text = "Limpiar", fontSize = 20.sp)
                        }
                        Button(modifier = Modifier.padding(start = 8.dp), onClick = {
                            navController.navigate("datitos")
                            yesViewModel.insertSaldo(
                                SaldoDia(
                                    id = null,
                                    dineroFisico = dineroFisico,
                                    dineroNotas = dineroNotas,
                                    dineroTotal = dineroTotal.toDouble(),
                                    fecha = currentDate
                                )
                            )
                        }) { Text(text = "Guardar") }
                    }
                    Text(
                        text = "Dinero Notas total $dineroNotas",
                        modifier = Modifier.padding(4.dp),
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Dinero Fisico total $dineroFisicoTotal",
                        modifier = Modifier.padding(4.dp),
                        fontSize = 20.sp
                    )
                    val colors: Color = if (dineroTotal.toDouble() > 0.1) {
                        Color.Green
                    } else if (dineroTotal.toDouble() < 0.0) {
                        Color.Red
                    } else {
                        Color.Black
                    }
                    val explicito: String = if (dineroTotal.toDouble() > 0.1) {
                        "Sobran"
                    } else if (dineroTotal.toDouble() < 0.0) {
                        "Faltan"
                    } else if (dineroTotal.toDouble() == 0.1) {
                        "Esperando cuenta"
                    } else {
                        "Todo Cuadra"
                    }
                    if (dineroTotal == "0.1") {
                        Text(
                            text = "Esperando cuenta",
                            modifier = Modifier.padding(4.dp),
                            fontSize = 20.sp
                        )
                    } else {
                        Text(
                            text = "Dinero Total del dia: $explicito $dineroTotal",
                            color = colors,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.padding(4.dp),
                            fontSize = 20.sp
                        )
                    }
                }
            }
        })
    }
}
