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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.patrykandpatrick.vico.compose.axis.horizontal.bottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.startAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.column.columnChart
import com.patrykandpatrick.vico.compose.component.shapeComponent
import com.patrykandpatrick.vico.compose.component.textComponent
import com.patrykandpatrick.vico.compose.dimensions.dimensionsOf
import com.patrykandpatrick.vico.core.DefaultDimens
import com.patrykandpatrick.vico.core.chart.decoration.ThresholdLine
import com.patrykandpatrick.vico.core.component.shape.LineComponent
import com.patrykandpatrick.vico.core.component.shape.Shapes
import com.patrykandpatrick.vico.core.entry.entryModelOf
import com.rodrigojscript.yesido.model.database.SaldoDia
import com.rodrigojscript.yesido.view.components.CustomCardCasita
import com.rodrigojscript.yesido.view.theme.BaseAppTheme
import com.rodrigojscript.yesido.viewmodel.YesViewModel

public val Color.Companion.DimmedGray: Color
    get() = Color(0xFFAAAAAA)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CasitaDeDatitos(navController: NavController, yesViewModel: YesViewModel) {
    BaseAppTheme {
        val list: List<SaldoDia> = yesViewModel.getAllSaldo().observeAsState(listOf()).value
        val lastSevenDineroTotal: List<Float> = list.takeLast(7).map { it.dineroTotal.toFloat() }

        val day1DineroTotal: Float = lastSevenDineroTotal.getOrNull(0) ?: 0f
        val day2DineroTotal: Float = lastSevenDineroTotal.getOrNull(1) ?: 0f
        val day3DineroTotal: Float = lastSevenDineroTotal.getOrNull(2) ?: 0f
        val day4DineroTotal: Float = lastSevenDineroTotal.getOrNull(3) ?: 0f
        val day5DineroTotal: Float = lastSevenDineroTotal.getOrNull(4) ?: 0f
        val day6DineroTotal: Float = lastSevenDineroTotal.getOrNull(5) ?: 0f
        val day7DineroTotal: Float = lastSevenDineroTotal.getOrNull(6) ?: 0f

        val chartEntryModel = entryModelOf(
            day1DineroTotal,
            day2DineroTotal,
            day3DineroTotal,
            day4DineroTotal,
            day5DineroTotal,
            day6DineroTotal,
            day7DineroTotal
        )

        Scaffold(topBar = {
            TopAppBar(title = { Text(text = "Datos Guardados") }, navigationIcon = {
                IconButton(
                    onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null)
                }
            })
        }, content = {
            Column(
                modifier = Modifier.padding(12.dp)
            ) {

                Chart(
                    chart = columnChart(
                        columns = listOf(
                            LineComponent(
                                color = -12303292,
                                thicknessDp = 10f,
                                shape = Shapes.roundedCornerShape(DefaultDimens.COLUMN_ROUNDNESS_PERCENT),
                            ),
                        ),
                    ).apply {
                        addDecoration(
                            ThresholdLine(
                                thresholdValue = 0f,
                                lineComponent = shapeComponent(color = Color.Black),
                                labelComponent = textComponent(
                                    Color.Black,
                                    padding = dimensionsOf(horizontal = 8.dp)
                                ),
                            ),
                        )
                    },
                    model = chartEntryModel,
                    startAxis = startAxis(),
                    bottomAxis = bottomAxis(),

                    )
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
}
