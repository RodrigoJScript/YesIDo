package com.rodrigojscript.yesido.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.rodrigojscript.yesido.ui.components.CustomCardNotas
import com.rodrigojscript.yesido.ui.theme.BaseAppTheme


var dineroNotas: Double = 0.0

@Composable
fun DineroNotas(navController: NavController) {
    var nota1 by remember { mutableStateOf("0") }
    var nota2 by remember { mutableStateOf("0") }
    var nota3 by remember { mutableStateOf("0") }
    var nota4 by remember { mutableStateOf("0") }
    var nota5 by remember { mutableStateOf("0") }
    var nota6 by remember { mutableStateOf("0") }
    var nota7 by remember { mutableStateOf("0") }
    var nota8 by remember { mutableStateOf("0") }
    var nota9 by remember { mutableStateOf("0") }
    var nota10 by remember { mutableStateOf("0") }
    var nota11 by remember { mutableStateOf("0") }
    var nota12 by remember { mutableStateOf("0") }
    var nota13 by remember { mutableStateOf("0") }
    var nota14 by remember { mutableStateOf("0") }
    var nota15 by remember { mutableStateOf("0") }

    var dineroTotal by remember { mutableStateOf("0.0") }
    BaseAppTheme {
        Scaffold(topBar = {
            TopAppBar(
                title = { Text(text = "Dinero Notas") }
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
                    CustomCardNotas(nmb = nota1, title = "Nota 1") {
                        nota1 = it
                    }
                    CustomCardNotas(nmb = nota2, title = "Nota 2") {
                        nota2 = it
                    }
                    CustomCardNotas(nmb = nota3, title = "Nota 3") {
                        nota3 = it
                    }
                    CustomCardNotas(nmb = nota4, title = "Nota 4") {
                        nota4 = it
                    }
                    CustomCardNotas(nmb = nota5, title = "Nota 5") {
                        nota5 = it
                    }
                    CustomCardNotas(nmb = nota6, title = "Nota 6") {
                        nota6 = it
                    }
                    CustomCardNotas(nmb = nota7, title = "Nota 7") {
                        nota7 = it
                    }
                    CustomCardNotas(nmb = nota8, title = "Nota 8") {
                        nota8 = it
                    }
                    CustomCardNotas(nmb = nota9, title = "Nota 9") {
                        nota9 = it
                    }
                    CustomCardNotas(nmb = nota10, title = "Nota 10") {
                        nota10 = it
                    }
                    CustomCardNotas(nmb = nota11, title = "Nota 11") {
                        nota11 = it
                    }
                    CustomCardNotas(nmb = nota12, title = "Nota 12") {
                        nota12 = it
                    }
                    CustomCardNotas(nmb = nota13, title = "Nota 13") {
                        nota13 = it
                    }
                    CustomCardNotas(nmb = nota14, title = "Nota 14") {
                        nota14 = it
                    }
                    CustomCardNotas(nmb = nota15, title = "Nota 15") {
                        nota15 = it
                    }
                    Button(onClick = {
                        val no1 = nota1.toDouble()
                        val no2 = nota2.toDouble()
                        val no3 = nota3.toDouble()
                        val no4 = nota4.toDouble()
                        val no5 = nota5.toDouble()
                        val no6 = nota6.toDouble()
                        val no7 = nota7.toDouble()
                        val no8 = nota8.toDouble()
                        val no9 = nota9.toDouble()
                        val no10 = nota10.toDouble()
                        val no11 = nota11.toDouble()
                        val no12 = nota12.toDouble()
                        val no13 = nota13.toDouble()
                        val no14 = nota14.toDouble()
                        val no15 = nota15.toDouble()
                        dineroNotas =
                            no1 + no2 + no3 + no4 + no5 + no6 + no7 + no8 + no9 + no10 + no11 + no12 + no13 + no14 + no15
                        dineroTotal = (dineroFisico - dineroNotas).toString()
                    }) {
                        Text(text = "Calcular")
                    }
                    Button(onClick = {
                        nota1 = "0"
                        nota2 = "0"
                        nota3 = "0"
                        nota4 = "0"
                        nota5 = "0"
                        nota6 = "0"
                        nota7 = "0"
                        nota8 = "0"
                        nota9 = "0"
                        nota10 = "0"
                        nota11 = "0"
                        nota12 = "0"
                        nota13 = "0"
                        nota14 = "0"
                        nota15 = "0"
                    }) {
                        Text(text = "Limpiar")
                    }
                    var colors: Color = Color.Green
                    colors = if (dineroTotal == "0.0") {
                        Color.Green
                    } else {
                        Color.Red
                    }
                    Text(text = dineroTotal, color = colors)
                }
            }
        })
    }
}