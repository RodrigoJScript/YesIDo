package com.rodrigojscript.yesido.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomCard(nmb: String, title: String, onChange: onChange) {
    Row(
        modifier = Modifier.padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, modifier = Modifier.padding(8.dp))
        CustomTextField(number = nmb) {
            onChange(it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomCardPreview() {
    CustomCard("100", "Title") {}
}