package com.rodrigojscript.yesido

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodrigojscript.yesido.view.screens.*
import com.rodrigojscript.yesido.view.theme.BaseAppTheme
import com.rodrigojscript.yesido.viewmodel.YesViewModel

/**
 * Main activity
 * @constructor Create empty Main activity
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val yesViewModel: YesViewModel = ViewModelProvider(this)[YesViewModel::class.java]
        setContent {
            BaseAppTheme {
                NavGraph()
            }
        }
    }
}
