package com.rodrigojscript.yesido

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodrigojscript.yesido.view.screens.CasitaDeDatitos
import com.rodrigojscript.yesido.view.screens.DineroFisico
import com.rodrigojscript.yesido.view.screens.DineroNotas
import com.rodrigojscript.yesido.view.screens.Reporte
import com.rodrigojscript.yesido.view.screens.SplashScreen
import com.rodrigojscript.yesido.viewmodel.YesViewModel

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object DineroFisico : Screen("dinerofisico")
    object Reporte : Screen("reporte")
    object DineroNotas : Screen("dineronotas")
    object Datitos : Screen("datitos")

}

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val yesViewModel: YesViewModel = YesViewModel(application = Application())
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { SplashScreen(navController) }
        composable(Screen.DineroFisico.route) { DineroFisico(navController, yesViewModel) }
        composable(Screen.Reporte.route) { Reporte(navController, yesViewModel) }
        composable(Screen.DineroNotas.route) { DineroNotas(navController, yesViewModel) }
        composable(Screen.Datitos.route) { CasitaDeDatitos(navController, yesViewModel) }
    }
}