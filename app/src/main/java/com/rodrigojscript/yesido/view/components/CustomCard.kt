package com.rodrigojscript.yesido.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CustomCardFisico(nmb: String, image: Int, onChange: onChange) {
    Row(
        modifier = Modifier.padding(2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .padding(start = 4.dp)
                .size(100.dp), painter = painterResource(id = image),
            contentDescription = null
        )
        CustomTextField(number = nmb) {
            onChange(it)
        }
    }
}

@Composable
fun CustomCardNotas(nmb: String, title: String, onChange: onChange) {
    Row(
        modifier = Modifier.padding(2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title)
        CustomTextField(number = nmb) {
            onChange(it)
        }
    }
}
