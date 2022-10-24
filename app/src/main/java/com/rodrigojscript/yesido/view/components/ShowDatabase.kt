package com.rodrigojscript.yesido.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rodrigojscript.yesido.model.database.DineroEnNotas
import com.rodrigojscript.yesido.model.database.SaldoDia
import com.rodrigojscript.yesido.viewmodel.YesViewModel

/**
 * Custom card casita
 *
 * @param item
 * @param yesViewModel
 */
@Composable
fun CustomCardCasita(item: SaldoDia, yesViewModel: YesViewModel) {
    val openDialog = remember { mutableStateOf(false) }

    if (openDialog.value) {
        AlertDialog(
            title = { Text(text = "Estas a punto de eliminar un registro") },
            text = {
                Text(
                    text = "¿Eliminar?"
                )
            },
            onDismissRequest = { openDialog.value = false },
            confirmButton = {
                TextButton(onClick = { // (4)
                    yesViewModel.deleteSaldo(item)
                }) {
                    Text(text = "Eliminar")
                }
            },
            dismissButton = {
                TextButton(onClick = { // (5)
                    openDialog.value = false
                }) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = " Fecha: ${item.fecha}",
                style = MaterialTheme.typography.caption,
                fontSize = 24.sp
            )
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Dinero Notas: $${item.dineroNotas}",
                    style = MaterialTheme.typography.caption,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Dinero fisico: $${item.dineroFisico}",
                    style = MaterialTheme.typography.caption,
                    fontSize = 16.sp
                )
            }
            Text(
                modifier = Modifier.padding(bottom = 4.dp),
                text = "Balance: $${item.dineroTotal}",
                style = MaterialTheme.typography.caption,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(onClick = { openDialog.value = true }) {
                Icon(Icons.Filled.Delete, "")
            }
        }
    }
}

@Composable
fun CustomCardNotas(item: DineroEnNotas, yesViewModel: YesViewModel) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = " Nota: ${item.dineroNota}",
            style = MaterialTheme.typography.caption,
            fontSize = 24.sp
        )
        IconButton(onClick = { yesViewModel.deleteNota(item) }) {
            Icon(Icons.Filled.Delete, "")
        }
    }
}