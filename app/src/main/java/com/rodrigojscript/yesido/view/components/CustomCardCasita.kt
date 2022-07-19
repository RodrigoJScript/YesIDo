package com.rodrigojscript.yesido.view.components

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.3f) },
                orientation = Orientation.Horizontal,
            )
            .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) },
        shape = MaterialTheme.shapes.medium,
        elevation = 8.dp,
    ) {
        if (swipeableState.isAnimationRunning) {
            DisposableEffect(Unit) {
                onDispose {
                    yesViewModel.deleteSaldo(item)
                }
            }
        }
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
        }
    }
}
