package com.rodrigojscript.yesido.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rodrigojscript.yesido.ui.components.CustomCardNotas
import com.rodrigojscript.yesido.ui.theme.BaseAppTheme


var dineroNotas: Double = 0.0

@Composable
fun DineroNotas(navController: NavController) {
    var nota1 by rememberSaveable { mutableStateOf("") }
    var nota2 by rememberSaveable { mutableStateOf("") }
    var nota3 by rememberSaveable { mutableStateOf("") }
    var nota4 by rememberSaveable { mutableStateOf("") }
    var nota5 by rememberSaveable { mutableStateOf("") }
    var nota6 by rememberSaveable { mutableStateOf("") }
    var nota7 by rememberSaveable { mutableStateOf("") }
    var nota8 by rememberSaveable { mutableStateOf("") }
    var nota9 by rememberSaveable { mutableStateOf("") }
    var nota10 by rememberSaveable { mutableStateOf("") }
    var nota11 by rememberSaveable { mutableStateOf("") }
    var nota12 by rememberSaveable { mutableStateOf("") }
    var nota13 by rememberSaveable { mutableStateOf("") }
    var nota14 by rememberSaveable { mutableStateOf("") }
    var nota15 by rememberSaveable { mutableStateOf("") }

    var dineroTotalNotas by remember { mutableStateOf("0.0") }
    BaseAppTheme {
        Scaffold(topBar = {
            TopAppBar(
                title = { Text(text = "Dinero Notas") })
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
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(modifier = Modifier.padding(8.dp), onClick = {
                            val no1: Double? = isNull(nota1)
                            val no2: Double? = isNull(nota2)
                            val no3: Double? = isNull(nota3)
                            val no4: Double? = isNull(nota4)
                            val no5: Double? = isNull(nota5)
                            val no6: Double? = isNull(nota6)
                            val no7: Double? = isNull(nota7)
                            val no8: Double? = isNull(nota8)
                            val no9: Double? = isNull(nota9)
                            val no10: Double? = isNull(nota10)
                            val no11: Double? = isNull(nota11)
                            val no12: Double? = isNull(nota12)
                            val no13: Double? = isNull(nota13)
                            val no14: Double? = isNull(nota14)
                            val no15: Double? = isNull(nota15)
                            dineroNotas =
                                if (no1 != null && no2 != null && no3 != null && no4 != null && no5 != null && no6 != null && no7 != null && no8 != null && no9 != null && no10 != null && no11 != null && no12 != null && no13 != null && no14 != null && no15 != null) {
                                    no1 + no2 + no3 + no4 + no5 + no6 + no7 + no8 + no9 + no10 + no11 + no12 + no13 + no14 + no15
                                } else {
                                    0.0
                                }
                            dineroTotalNotas = dineroNotas.toString()
                        }) {
                            Text(text = "Calcular", fontSize = 20.sp)
                        }
                        Button(
                            modifier = Modifier.padding(8.dp),
                            onClick = { navController.navigate("dinerofisico") }) {
                            Text(text = "Siguiente", fontSize = 20.sp)
                        }
                    }
                    Button(modifier = Modifier.padding(bottom = 8.dp), onClick = {
                        nota1 = ""
                        nota2 = ""
                        nota3 = ""
                        nota4 = ""
                        nota5 = ""
                        nota6 = ""
                        nota7 = ""
                        nota8 = ""
                        nota9 = ""
                        nota10 = ""
                        nota11 = ""
                        nota12 = ""
                        nota13 = ""
                        nota14 = ""
                        nota15 = ""
                        dineroTotalNotas = "0.0"
                    }) {
                        Text(text = "Limpiar", fontSize = 20.sp)
                    }
                    Text(text = "Dinero total de notas: $dineroTotalNotas", fontSize = 20.sp)
                }
            }
        })
    }
}

fun isNull(input: String): Double? {
    return try {
        input.toDouble()
    } catch (e: NumberFormatException) {
        0.0
    }
}
