package com.rodrigojscript.yesido.view.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable

@Composable
fun BaseAppTheme(content: @Composable () -> Unit) {
    YesIDoTheme {
        Surface(color = MaterialTheme.colors.background)
        {
            content()
        }
    }
}