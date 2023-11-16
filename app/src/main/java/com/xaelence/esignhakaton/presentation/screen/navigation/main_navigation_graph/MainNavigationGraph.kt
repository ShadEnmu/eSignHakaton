package com.xaelence.esignhakaton.presentation.screen.navigation.main_navigation_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.xaelence.esignhakaton.presentation.screen.AppScreen
import com.xaelence.esignhakaton.presentation.screen.login_screen.LoginScreen
import com.xaelence.esignhakaton.presentation.screen.main_screen.MainScreen

@Composable
fun MainNavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MainNavigationItems.LoginScreen.route) {

        composable(MainNavigationItems.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(MainNavigationItems.AppScreen.route) {
            AppScreen()
        }
    }

}