package com.rodrigojscript.yesido.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rodrigojscript.yesido.model.database.DineroEnNotas
import com.rodrigojscript.yesido.view.screens.dineroNotas
import com.rodrigojscript.yesido.viewmodel.YesViewModel

/**
 * Custom card fisico
 *
 * @param nmb
 * @param valor
 * @param onChange
 */
@Composable
fun CustomCardFisico(nmb: String, valor: String, onChange: onChange) {
    Row(
        modifier = Modifier.padding(2.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(modifier = Modifier.padding(end = 8.dp), text = valor, fontSize = 20.sp)
        CustomTextField(number = nmb) {
            onChange(it)
        }
    }
}