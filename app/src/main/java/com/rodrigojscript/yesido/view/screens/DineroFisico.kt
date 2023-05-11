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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rodrigojscript.yesido.view.components.CustomTextField
import com.rodrigojscript.yesido.view.theme.BaseAppTheme
import com.rodrigojscript.yesido.viewmodel.YesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

var dineroFisico: Double = 0.0
var colors: Color = Color.Black
var explicito: String = "Todo cuadra"
var dineroTotal: String = "0.0"
var valorIndividual = arrayOfNulls<String>(11)

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DineroFisico(navController: NavController, yesViewModel: YesViewModel) {
    val textFieldValue = remember { mutableStateListOf("", "", "", "", "", "", "", "", "", "", "") }
    val textFieldValues = remember { mutableStateListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0) }
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
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        innerPaddings
                    )
            ) {
                item {
                    for (i in 0..10) {
                        CustomTextField(
                            value = textFieldValue[i],
                            label = when (i) {
                                0 -> "$1000"
                                1 -> "$500"
                                2 -> "$200"
                                3 -> "$100"
                                4 -> "$50"
                                5 -> "$20"
                                6 -> "$10"
                                7 -> "$5"
                                8 -> "$2"
                                9 -> "$1"
                                10 -> "50¢"
                                else -> ""
                            }, valorIndividual = valorIndividual, index = i
                        ) {
                            textFieldValue[i] = it
                            textFieldValues[i] = textFieldValue[i].toIntOrNull() ?: 0
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        coroutineScope.launch {
                            withContext(Dispatchers.IO) {
                                valorIndividual[0] = (textFieldValues[0] * 1000.0).toString()
                                valorIndividual[1] = (textFieldValues[1] * 500.0).toString()
                                valorIndividual[2] = (textFieldValues[2] * 200.0).toString()
                                valorIndividual[3] = (textFieldValues[3] * 100.0).toString()
                                valorIndividual[4] = (textFieldValues[4] * 50.0).toString()
                                valorIndividual[5] = (textFieldValues[5] * 20.0).toString()
                                valorIndividual[6] = (textFieldValues[6] * 10.0).toString()
                                valorIndividual[7] = (textFieldValues[7] * 5.0).toString()
                                valorIndividual[8] = (textFieldValues[8] * 2.0).toString()
                                valorIndividual[9] = (textFieldValues[9] * 1.0).toString()
                                valorIndividual[10] = (textFieldValues[10] * 0.5).toString()
                                dineroFisico = textFieldValues[0] * 1000.0 +
                                        textFieldValues[1] * 500.0 +
                                        textFieldValues[2] * 200.0 +
                                        textFieldValues[3] * 100.0 +
                                        textFieldValues[4] * 50.0 +
                                        textFieldValues[5] * 20.0 +
                                        textFieldValues[6] * 10.0 +
                                        textFieldValues[7] * 5.0 +
                                        textFieldValues[8] * 2.0 +
                                        textFieldValues[9] * 1.0 +
                                        textFieldValues[10] * 0.5
                                dineroFisicoTotal = dineroFisico.toString()
                                dineroTotal = (dineroFisico - dineroNotas).toString()
                                yesViewModel.explicidad(dineroTotal.toDouble())
                            }
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
                            navController.navigate("dineronotas")
                        }) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                Icons.Default.ArrowBack,
                                modifier = Modifier.size(28.dp),
                                contentDescription = null
                            )
                            Text(text = "Notas")
                        }
                    }
                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .clickable {
                            if (dineroTotal.toDouble() == 0.0) {
                                explicito = "Todo cuadra"
                                colors = Color.Black
                            } else {
                                explicito = "Hay desbalance"
                                colors = Color.Red
                            }
                            yesViewModel.explicidad(dineroTotal.toDouble())
                            navController.navigate("reporte")
                        }) {
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
                }
            })
        })
    }
}