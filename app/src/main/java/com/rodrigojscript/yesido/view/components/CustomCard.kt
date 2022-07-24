package com.rodrigojscript.yesido.view.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

@Composable
fun CustomCardNotas(nmb: String, title: String, onChange: onChange) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, start = 16.dp, end = 16.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, fontSize = 20.sp)
        CustomTextField(number = nmb) {
            onChange(it)
        }
    }
}
