package com.rodrigojscript.yesido.view.components

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rodrigojscript.yesido.model.database.SaldoDia
import com.rodrigojscript.yesido.viewmodel.YesViewModel
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomCardCasita(item: SaldoDia, yesViewModel: YesViewModel) {
    val squareSize = 48.dp

    val swipeableState = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1)
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
                Spacer(modifier = Modifier.weight(1F))
                IconButton(onClick = { yesViewModel.deleteSaldo(item) }) {
                    Icon(Icons.Filled.Delete, "")
                }
            }
            Text(
                modifier = Modifier.padding(bottom = 4.dp),
                text = "Balance: $${item.dineroTotal}",
                style = MaterialTheme.typography.caption,
                fontSize = 16.sp
            )
        }
    }
}
