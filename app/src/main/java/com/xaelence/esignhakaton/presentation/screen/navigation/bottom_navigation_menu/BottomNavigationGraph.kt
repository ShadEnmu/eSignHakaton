package com.xaelence.esignhakaton.presentation.screen.navigation.bottom_navigation_menu

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.xaelence.esignhakaton.presentation.screen.local_cabinet.LocalCabinetScreen
import com.xaelence.esignhakaton.presentation.screen.main_screen.MainScreen

@Composable
fun BottomNavigationGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = BottomNavigationItems.MainScreen.route) {
        composable(BottomNavigationItems.MainScreen.route) {
            MainScreen()
        }

        composable(BottomNavigationItems.LocalCabinet.route) {
            LocalCabinetScreen()
        }
    }
}