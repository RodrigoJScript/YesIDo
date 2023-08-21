package com.rodrigojscript.yesido.view.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.patrykandpatrick.vico.compose.axis.horizontal.bottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.startAxis
import com.patrykandpatrick.vico.compose.chart.column.columnChart
import com.patrykandpatrick.vico.compose.component.shapeComponent
import com.patrykandpatrick.vico.compose.component.textComponent
import com.patrykandpatrick.vico.compose.dimensions.dimensionsOf
import com.patrykandpatrick.vico.core.DefaultDimens
import com.patrykandpatrick.vico.core.chart.decoration.ThresholdLine
import com.patrykandpatrick.vico.core.component.shape.LineComponent
import com.patrykandpatrick.vico.core.component.shape.Shapes
import com.patrykandpatrick.vico.core.entry.ChartEntryModel

@Composable
fun CustomChart(model: ChartEntryModel) {
    com.patrykandpatrick.vico.compose.chart.Chart(
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
                        Color.Black, padding = dimensionsOf(horizontal = 8.dp)
                    ),
                ),
            )
        },
        model = model,
        startAxis = startAxis(),
        bottomAxis = bottomAxis(),
    )
}