package com.rodrigojscript.yesido.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rodrigojscript.yesido.model.database.SaldoDia
import com.rodrigojscript.yesido.view.components.CustomCardFisico
import com.rodrigojscript.yesido.view.theme.BaseAppTheme
import com.rodrigojscript.yesido.viewmodel.YesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

var dineroFisico: Double = 0.0
var colors: Color = Color.Black
var explicito: String = "Todo cuadra"


/**
 * Dinero fisico
 *
 * @param navController
 * @param yesViewModel
 */
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DineroFisico(navController: NavController, yesViewModel: YesViewModel) {
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
    var dineroFisicoTotal by remember { mutableStateOf("$0.0") }
    var dineroTotal by remember { mutableStateOf("$0.0") }
    val coroutineScope = rememberCoroutineScope()

    @SuppressLint("SimpleDateFormat")
    val sdf = SimpleDateFormat("dd/M/yyyy")
    val currentDate: String = sdf.format(Date())

    BaseAppTheme {
        Scaffold(topBar = {
            TopAppBar(
                title = { Text(text = "Dinero fisico") }, navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigate("dineronotas")
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
                    CustomCardFisico(nmb = numberMil, valor = "$1000") {
                        numberMil = it
                    }
                    CustomCardFisico(nmb = numberQui, valor = "$500") {
                        numberQui = it
                    }
                    CustomCardFisico(nmb = numberDoc, valor = "$200") {
                        numberDoc = it
                    }
                    CustomCardFisico(nmb = numberCie, valor = "$100") {
                        numberCie = it
                    }
                    CustomCardFisico(nmb = numberCin, valor = "$50") {
                        numberCin = it
                    }
                    CustomCardFisico(nmb = numberVei, valor = "$20") {
                        numberVei = it
                    }
                    CustomCardFisico(nmb = numberDie, valor = "$10") {
                        numberDie = it
                    }
                    CustomCardFisico(nmb = numberCco, valor = "$5") {
                        numberCco = it
                    }
                    CustomCardFisico(nmb = numberDos, valor = "$2") {
                        numberDos = it
                    }
                    CustomCardFisico(nmb = numberUno, valor = "$1") {
                        numberUno = it
                    }
                    CustomCardFisico(nmb = numberCen, valor = "50¢") {
                        numberCen = it
                    }
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        coroutineScope.launch(Dispatchers.IO) {
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
                            yesViewModel.explicidad(dineroTotal.toDouble())
                        }
                        Button(onClick = {

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
                        }) {
                            Icon(Icons.Filled.Done, contentDescription = null)
                            Spacer(modifier = Modifier.padding(2.dp))
                            Text(text = "Guardar", fontSize = 20.sp)
                        }
                    }
                    Button(modifier = Modifier.padding(end = 16.dp), onClick = {
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
                        dineroFisicoTotal = "$0.0"
                        dineroTotal = "$0.0"

                    }) {
                        Icon(Icons.Filled.Clear, contentDescription = null)
                        Spacer(modifier = Modifier.padding(2.dp))
                        Text(text = "Limpiar", fontSize = 20.sp)
                    }
                    Text(
                        text = "Dinero Notas total $$dineroNotas",
                        modifier = Modifier.padding(4.dp),
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Dinero Fisico total $$dineroFisicoTotal",
                        modifier = Modifier.padding(4.dp),
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Dinero Total del dia: $explicito $$dineroTotal",
                        color = colors,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.padding(4.dp),
                        fontSize = 20.sp
                    )
                }
            }
        })
    }
}