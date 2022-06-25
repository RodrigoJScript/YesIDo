package com.rodrigojscript.yesido.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rodrigojscript.yesido.R

@Composable
fun CustomCardFisico(nmb: String, image: Int, onChange: onChange) {
    Row(
        modifier = Modifier.padding(4.dp),
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
        modifier = Modifier.padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title)
        CustomTextField(number = nmb) {
            onChange(it)
        }
    }
}
