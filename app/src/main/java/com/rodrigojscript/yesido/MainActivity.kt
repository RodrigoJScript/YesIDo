package com.rodrigojscript.yesido

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodrigojscript.yesido.view.screens.CasitaDeDatitos
import com.rodrigojscript.yesido.view.screens.DineroFisico
import com.rodrigojscript.yesido.view.screens.DineroNotas
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "dineronotas") {
                composable("dinerofisico") { DineroFisico(navController) }
                composable("dineronotas") { DineroNotas(navController) }
                composable("datitos") { CasitaDeDatitos(navController) }
            }

        }
    }
}
