package com.rodrigojscript.yesido.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rodrigojscript.yesido.model.database.SaldoDia
import com.rodrigojscript.yesido.view.components.CustomCardCasita
import com.rodrigojscript.yesido.view.components.CustomChart
import com.rodrigojscript.yesido.viewmodel.YesViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CasitaDeDatitos(navController: NavController, yesViewModel: YesViewModel) {
    val list: List<SaldoDia> = yesViewModel.getAllSaldo().observeAsState(listOf()).value
    val chartEntryModel = yesViewModel.getLastSevenDayDineroTotal(list)

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Datos Guardados") }, navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        })
    }, content = {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            CustomChart(model = chartEntryModel)
            LazyColumn(
                contentPadding = PaddingValues(12.dp)
            ) {
                itemsIndexed(list) { _, item ->
                    CustomCardCasita(item, yesViewModel)
                    Spacer(modifier = Modifier.padding(4.dp))
                }
            }
        }
    })
}