package com.rodrigojscript.yesido.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rodrigojscript.yesido.model.database.SaldoDia
import com.rodrigojscript.yesido.view.components.CustomCardCasita
import com.rodrigojscript.yesido.viewmodel.YesViewModel

@Composable
fun CasitaDeDatitos(navController: NavController, yesViewModel: YesViewModel) {
    val list: List<SaldoDia> = yesViewModel.getAllSaldo().observeAsState(listOf()).value
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Casita De Datitos") }, navigationIcon = {
            IconButton(
                onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        })
    }, content = {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(vertical = 12.dp)
            ) {
                itemsIndexed(list) { _, item ->
                    CustomCardCasita(item, yesViewModel)
                }
            }
        }
    })
}