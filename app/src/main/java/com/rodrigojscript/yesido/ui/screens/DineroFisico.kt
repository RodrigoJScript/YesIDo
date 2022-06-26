package com.rodrigojscript.yesido.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rodrigojscript.yesido.R
import com.rodrigojscript.yesido.ui.components.CustomCardFisico
import com.rodrigojscript.yesido.ui.theme.BaseAppTheme
import java.time.format.TextStyle

var dineroFisico: Double = 0.0

@Composable
fun DineroFisico(navController: NavController) {
    var numberMil by remember { mutableStateOf("0") }
    var numberQui by remember { mutableStateOf("0") }
    var numberDoc by remember { mutableStateOf("0") }
    var numberCie by remember { mutableStateOf("0") }
    var numberCin by remember { mutableStateOf("0") }
    var numberVei by remember { mutableStateOf("0") }
    var numberDie by remember { mutableStateOf("0") }
    var numberCco by remember { mutableStateOf("0") }
    var numberDos by remember { mutableStateOf("0") }
    var numberUno by remember { mutableStateOf("0") }
    var numberCen by remember { mutableStateOf("0") }
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
                    Row (modifier= Modifier.padding(8.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Button(modifier = Modifier.padding(end = 8.dp), onClick = {
                            val nMil = numberMil.toDouble() * 1000
                            val nQui = numberQui.toDouble() * 500
                            val nDoc = numberDoc.toDouble() * 200
                            val nCie = numberCie.toDouble() * 100
                            val nCin = numberCin.toDouble() * 50
                            val nVei = numberVei.toDouble() * 20
                            val nDie = numberDie.toDouble() * 10
                            val nCco = numberCco.toDouble() * 5
                            val nDos = numberDos.toDouble() * 2
                            val nUno = numberUno.toDouble() * 1
                            val nCen = numberCen.toDouble() * 0.5
                            dineroFisico =
                                nMil + nQui + nDoc + nCie + nCin + nVei + nDie + nCco + nDos + nUno + nCen
                            dineroFisicoTotal = dineroFisico.toString()
                            dineroTotal = (dineroFisico - dineroNotas).toString()
                        }) {
                            Text(text = "Suma", fontSize = 20.sp)
                        }
                        Button(modifier = Modifier.padding(start = 8.dp), onClick = {
                            numberMil = "0"
                            numberQui = "0"
                            numberDoc = "0"
                            numberCie = "0"
                            numberCin = "0"
                            numberVei = "0"
                            numberDie = "0"
                            numberCco = "0"
                            numberDos = "0"
                            numberUno = "0"
                            numberCen = "0"
                            dineroFisicoTotal = "0"
                            dineroTotal = "0"
                        }) {
                            Text(text = "Limpiar", fontSize = 20.sp)
                        }
                    }
                    Text(text = "Dinero Notas total $dineroNotas", modifier = Modifier.padding(4.dp), fontSize = 20.sp)
                    Text(text = "Dinero Fisico total $dineroFisicoTotal", modifier = Modifier.padding(4.dp), fontSize = 20.sp)
                    val colors: Color = if (dineroTotal.toDouble() > 0.1) {
                        Color.Green
                    }
                    else if(dineroTotal.toDouble() < 0.0) {
                        Color.Red
                    }else{
                        Color.Black
                    }
                    val explicito:String = if (dineroTotal.toDouble() > 0.1) {
                        "Ganaste"
                    }
                    else if(dineroTotal.toDouble() < 0.0) {
                        "Perdiste"
                    }else if(dineroTotal.toDouble() == 0.1){
                        "Esperando cuenta"
                    }else {
                        "Todo Cuadra"
                    }
                    if (dineroTotal == "0.1"){
                     Text(text ="Esperando cuenta", modifier = Modifier.padding(4.dp), fontSize = 20.sp)
                    }else{
                        Text(text = "Dinero Total del dia: $explicito $dineroTotal", color = colors, textDecoration = TextDecoration.Underline, modifier = Modifier.padding(4.dp), fontSize = 20.sp)
                    }
                }
            }
        })
    }
}