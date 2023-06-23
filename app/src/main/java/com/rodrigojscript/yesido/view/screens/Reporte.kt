package com.rodrigojscript.yesido.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rodrigojscript.yesido.model.database.SaldoDia
import com.rodrigojscript.yesido.view.theme.BaseAppTheme
import com.rodrigojscript.yesido.viewmodel.YesViewModel
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Reporte(navController: NavHostController, yesViewModel: YesViewModel) {
    @SuppressLint("SimpleDateFormat") val sdf = SimpleDateFormat("dd/M/yyyy")
    val currentDate: String = sdf.format(Date())
    BaseAppTheme {
        Scaffold(topBar = {
            TopAppBar(title = { Text(text = "Reporte") })
        }, content = {
            Column {
                Text(
                    text = "Dinero Notas total $$dineroNotas",
                    modifier = Modifier.padding(4.dp),
                    fontSize = 30.sp,
                )
                Text(
                    text = "Dinero Fisico total $$dineroFisico",
                    modifier = Modifier.padding(4.dp),
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "Dinero Total del dia: $explicito $$dineroTotal",
                    color = colors,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.padding(4.dp),
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center
                )
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
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                Icons.Default.Done,
                                modifier = Modifier.size(28.dp),
                                contentDescription = null
                            )
                            Text(text = "Guardar")
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