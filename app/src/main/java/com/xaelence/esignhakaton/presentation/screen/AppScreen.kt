package com.xaelence.esignhakaton.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.xaelence.esignhakaton.presentation.screen.navigation.bottom_navigation_menu.BottomNavigationGraph
import com.xaelence.esignhakaton.presentation.screen.navigation.bottom_navigation_menu.BottomNavigationView

@Composable
fun AppScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationView(navController = navController) }
    ) {
        BottomNavigationGraph(navController = navController)
    }
}