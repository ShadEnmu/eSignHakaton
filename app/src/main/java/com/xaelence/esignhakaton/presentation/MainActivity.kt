package com.xaelence.esignhakaton.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.xaelence.esignhakaton.presentation.screen.navigation.main_navigation_graph.MainNavigationGraph
import dagger.hilt.android.AndroidEntryPoint
import java.security.Security

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            Scaffold(
                modifier = Modifier.fillMaxSize()
            ) {
                MainNavigationGraph(navController = navController)
            }
        }
    }
}
