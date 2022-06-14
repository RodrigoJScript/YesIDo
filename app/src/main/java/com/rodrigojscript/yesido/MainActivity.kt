package com.rodrigojscript.yesido

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodrigojscript.yesido.ui.screens.DineroFisico
import com.rodrigojscript.yesido.ui.screens.DineroNotas
import com.rodrigojscript.yesido.ui.theme.BaseAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "dinerofisico") {
                composable("dinerofisico") { DineroFisico(navController) }
                composable("dineronotas") { DineroNotas(navController) }
            }
        }
    }
}
