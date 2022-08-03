package com.rodrigojscript.yesido.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rodrigojscript.yesido.view.components.CustomCardNotas
import com.rodrigojscript.yesido.view.theme.BaseAppTheme
import com.rodrigojscript.yesido.viewmodel.YesViewModel

var dineroNotas: Double = 0.0

/**
 * Dinero notas
 *
 * @param navController
 * @param yesViewModel
 */
@Composable
fun DineroNotas(navController: NavController, yesViewModel: YesViewModel) {
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

    var dineroTotalNotas by remember { mutableStateOf("$0.0") }
    BaseAppTheme {
        Scaffold(topBar = {
            TopAppBar(
                title = { Text(text = "Dinero Notas") }, navigationIcon = {
                    IconButton(onClick = { navController.navigate("datitos") }
                    ) {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = null
                        )
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
                            yesViewModel.calcularDN(
                                n1 = nota1,
                                n2 = nota2,
                                n3 = nota3,
                                n4 = nota4,
                                n5 = nota5,
                                n6 = nota6,
                                n7 = nota7,
                                n8 = nota8,
                                n9 = nota9,
                                n10 = nota10,
                                n11 = nota11,
                                n12 = nota12,
                                n13 = nota13,
                                n14 = nota14,
                                n15 = nota15,
                            )
                            dineroTotalNotas = "$$dineroNotas"
                        }) {
                            Icon(Icons.Filled.Add, contentDescription = null)
                            Spacer(modifier = Modifier.padding(2.dp))
                            Text(text = "Calcular", fontSize = 20.sp)
                        }
                        Button(
                            modifier = Modifier.padding(8.dp),
                            onClick = { navController.navigate("dinerofisico") }) {
                            Icon(Icons.Filled.ArrowForward, contentDescription = null)
                            Spacer(modifier = Modifier.padding(2.dp))
                            Text(text = "Siguiente", fontSize = 20.sp)
                        }
                    }
                    Button(
                        modifier = Modifier.padding(8.dp),
                        onClick = {
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
                            dineroTotalNotas = "$0.0"
                        }) {
                        Icon(Icons.Filled.Clear, contentDescription = null)
                        Spacer(modifier = Modifier.padding(2.dp))
                        Text(text = "Limpiar", fontSize = 20.sp)
                    }
                    Text(
                        modifier = Modifier.padding(bottom = 4.dp),
                        text = "Dinero total de notas: $dineroTotalNotas",
                        fontSize = 20.sp
                    )
                }
            }
        })
    }
}