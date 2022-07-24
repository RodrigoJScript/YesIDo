package com.rodrigojscript.yesido.view.screens

import android.window.SplashScreenView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rodrigojscript.yesido.R
import com.rodrigojscript.yesido.view.theme.BaseAppTheme

@Composable
fun SplashScreen(navController: NavController) {
    BaseAppTheme {
        LaunchedEffect(key1 = true) {
            navController.popBackStack()
            navController.navigate("dineronotas")
        }

        Splash()
    }
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.icoyid),
            contentDescription = "Logo de aplicacion",
            modifier = Modifier.size(250.dp, 250.dp)
        )
    }
}
