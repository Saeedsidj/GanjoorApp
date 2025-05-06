package com.saeedev.ganjoor.ir

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saeedev.ganjoor.ir.presentation.poetsList.PoetListDestination
import com.saeedev.ganjoor.ir.presentation.poetsList.PoetsListScreen
import com.saeedev.ganjoor.ir.ui.theme.GanjoorAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                val navController = rememberNavController()
                GanjoorAppTheme {
                    NavHost(
                        navController = navController,
                        startDestination = PoetListDestination
                    ) {
                        composable<PoetListDestination> {
                            PoetsListScreen()
                        }
                    }
                }
            }
        }
    }
}