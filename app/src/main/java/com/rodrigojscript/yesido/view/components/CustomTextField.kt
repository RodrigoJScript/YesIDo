package com.rodrigojscript.yesido.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

typealias onChange = (String) -> Unit

/**
 * Custom text field
 *
 * @param number
 * @param onChange
 */
@Composable
fun CustomTextField(nmb: String, valor: String, onChange: onChange) {
    OutlinedTextField(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = 2.dp, bottom = 2.dp),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        value = nmb,
        singleLine = true,
        shape = MaterialTheme.shapes.medium,
        onValueChange = { onChange(it) },
        textStyle = MaterialTheme.typography.body1,
        label = { Text(text = valor) }
    )
}
