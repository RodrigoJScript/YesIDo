package com.rodrigojscript.yesido.view.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

var dineroNotas: Double = 0.0

/**
 * Dinero notas
 *
 * @param navController
 * @param yesViewModel
 */
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DineroNotas(navController: NavController, yesViewModel: YesViewModel) {
    var nota1 by rememberSaveable { mutableStateOf("") }
    val list: List<DineroEnNotas> = yesViewModel.getAllNotas().observeAsState(listOf()).value
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    var dineroTotalNotas by remember { mutableStateOf("$0.0") }

    BaseAppTheme {
        Scaffold(topBar = {
            TopAppBar(title = { Text(text = "Dinero Notas") })
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
                        OutlinedTextField(modifier = Modifier
                            .padding(8.dp)
                            .padding(top = 14.dp)
                            .fillMaxWidth(),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number, imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(onDone = {
                                if (nota1.isEmpty()) {
                                    yesViewModel.insertNotas(
                                        DineroEnNotas(
                                            id = null, dineroNota = 0.0
                                        )
                                    )
                                    nota1 = ""
                                } else {
                                    yesViewModel.insertNotas(
                                        DineroEnNotas(
                                            id = null, dineroNota = nota1.toDouble()
                                        )
                                    )
                                    nota1 = ""
                                }
                            }),
                            value = nota1,
                            singleLine = true,
                            shape = MaterialTheme.shapes.medium,
                            onValueChange = { nota1 = it },
                            textStyle = MaterialTheme.typography.body1,
                            label = { Text(text = "Notas") })
                    }
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier.padding(bottom = 4.dp),
                            text = "Dinero Notas: $dineroTotalNotas",
                            fontSize = 40.sp
                        )
                        coroutineScope.launch(Dispatchers.IO) {
                            dineroNotas = list.sumOf { it.dineroNota }
                            dineroTotalNotas = "$$dineroNotas"
                        }
                    }
                }
                itemsIndexed(list) { _, item ->
                    CustomCardNotas(item, yesViewModel)
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
                        .clickable { yesViewModel.clear() }) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                Icons.Default.Clear,
                                modifier = Modifier
                                    .size(28.dp),
                                contentDescription = null
                            )
                            Text(text = "Limpiar")
                        }
                    }

                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .clickable { navController.navigate("dinerofisico") }) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                Icons.Default.ArrowForward,
                                modifier = Modifier
                                    .size(28.dp),
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
                                modifier = Modifier
                                    .size(28.dp),
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

