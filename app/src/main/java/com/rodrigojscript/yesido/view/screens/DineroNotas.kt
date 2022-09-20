package com.rodrigojscript.yesido.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rodrigojscript.yesido.model.database.DineroEnNotas
import com.rodrigojscript.yesido.model.database.SaldoDia
import com.rodrigojscript.yesido.view.components.CustomCardCasita
import com.rodrigojscript.yesido.view.components.CustomCardNotas
import com.rodrigojscript.yesido.view.components.onChange
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
    val list: List<DineroEnNotas> = yesViewModel.getAllNotas().observeAsState(listOf()).value

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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp, start = 16.dp, end = 16.dp, bottom = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Nota", fontSize = 20.sp)
                        OutlinedTextField(
                            modifier = Modifier
                                .padding(8.dp)
                                .padding(top = 14.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    yesViewModel.insertNotas(
                                        DineroEnNotas(
                                            id = null,
                                            dineroNota = nota1.toDouble()
                                        )
                                    )
                                    nota1 = ""
                                }
                            ),
                            value = nota1,
                            singleLine = true,
                            shape = MaterialTheme.shapes.medium,
                            onValueChange = { nota1 = it },
                            textStyle = MaterialTheme.typography.body1,
                            label = { Text(text = "Dinero") }
                        )
                    }
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(modifier = Modifier.padding(8.dp), onClick = {
                            dineroNotas = list.sumOf { it.dineroNota }
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
                itemsIndexed(list) { _, item ->
                    CustomCardNotas(item, yesViewModel)
                }
            }
        })
    }
}
