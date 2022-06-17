package com.rodrigojscript.yesido.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

typealias onChange = (String) -> Unit

@Composable
fun CustomTextField(number: String, onChange: onChange) {
    TextField(
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        value = number,
        modifier = Modifier
            .padding(8.dp)
            .padding(top = 14.dp),
        singleLine = true,
        shape = MaterialTheme.shapes.medium,
        onValueChange = { onChange(it) },
        textStyle = MaterialTheme.typography.body1
    )
}

@Preview(showBackground = true)
@Composable
fun CustomTextFieldPreview() {
    CustomTextField("20") {}
}