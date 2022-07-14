package com.rodrigojscript.yesido

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodrigojscript.yesido.view.screens.CasitaDeDatitos
import com.rodrigojscript.yesido.view.screens.DineroFisico
import com.rodrigojscript.yesido.view.screens.DineroNotas
import com.rodrigojscript.yesido.viewmodel.YesViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val yesViewModel: YesViewModel = ViewModelProvider(this)[YesViewModel::class.java]
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "dineronotas") {
                composable("dinerofisico") { DineroFisico(navController, yesViewModel) }
                composable("dineronotas") { DineroNotas(navController, yesViewModel) }
                composable("datitos") { CasitaDeDatitos(navController, yesViewModel) }
            }

        }
    }
}
