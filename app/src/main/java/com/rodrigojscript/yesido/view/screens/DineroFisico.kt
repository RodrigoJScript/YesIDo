package com.rodrigojscript.yesido.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import com.rodrigojscript.yesido.view.components.CustomTextField
import com.rodrigojscript.yesido.view.theme.BaseAppTheme
import com.rodrigojscript.yesido.viewmodel.YesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

var dineroFisico: Double = 0.0
var colors: Color = Color.Black
var explicito: String = "Todo cuadra"
var dineroTotal: String = "0.0"


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
    var dineroFisicoTotal by rememberSaveable { mutableStateOf("0.0") }
    val coroutineScope = rememberCoroutineScope()

    BaseAppTheme {
        Scaffold(topBar = {
            TopAppBar(title = { Text(text = "Dinero fisico") }, navigationIcon = {
                IconButton(
                    onClick = {
                        navController.navigate("dineronotas")
                    },

                    ) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null)
                }
            })
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
                    CustomTextField(nmb = numberMil, valor = "$1000") {
                        numberMil = it
                    }
                    CustomTextField(nmb = numberQui, valor = "$500") {
                        numberQui = it
                    }
                    CustomTextField(nmb = numberDoc, valor = "$200") {
                        numberDoc = it
                    }
                    CustomTextField(nmb = numberCie, valor = "$100") {
                        numberCie = it
                    }
                    CustomTextField(nmb = numberCin, valor = "$50") {
                        numberCin = it
                    }
                    CustomTextField(nmb = numberVei, valor = "$20") {
                        numberVei = it
                    }
                    CustomTextField(nmb = numberDie, valor = "$10") {
                        numberDie = it
                    }
                    CustomTextField(nmb = numberCco, valor = "$5") {
                        numberCco = it
                    }
                    CustomTextField(nmb = numberDos, valor = "$2") {
                        numberDos = it
                    }
                    CustomTextField(nmb = numberUno, valor = "$1") {
                        numberUno = it
                    }
                    CustomTextField(nmb = numberCen, valor = "50¢") {
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
                    }
                    Text(
                        modifier = Modifier.padding(bottom = 4.dp, start = 4.dp),
                        text = "Dinero Fisico: $$dineroFisicoTotal",
                        fontSize = 40.sp
                    )
                }
            }
        }, bottomBar = {
            BottomAppBar(content = {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .clickable {
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
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                Icons.Default.Clear,
                                modifier = Modifier.size(28.dp),
                                contentDescription = null
                            )
                            Text(text = "Limpiar")
                        }
                    }

                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .clickable { navController.navigate("reporte") }) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                Icons.Default.ArrowForward,
                                modifier = Modifier.size(28.dp),
                                contentDescription = null
                            )
                            Text(text = "Siguiente")
                        }
                    }

                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .clickable { navController.navigate("datitos") }) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                Icons.Default.Home,
                                modifier = Modifier.size(28.dp),
                                contentDescription = null
                            )
                            Text(text = "Datos")
                        }
                    }
                }
            })
        })
    }
}