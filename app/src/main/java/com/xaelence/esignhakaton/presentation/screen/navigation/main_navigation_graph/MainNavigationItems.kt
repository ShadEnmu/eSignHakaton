package com.xaelence.esignhakaton.presentation.screen.navigation.main_navigation_graph

sealed class MainNavigationItems(val title: String, val route: String) {
    data object LoginScreen: MainNavigationItems("Login Screen", "login_screen")
    data object AppScreen: MainNavigationItems("Main Screen", "app_screen")
}
