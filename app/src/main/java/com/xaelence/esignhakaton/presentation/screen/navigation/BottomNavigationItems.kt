package com.xaelence.esignhakaton.presentation.screen.navigation

sealed class BottomNavigationItems(val name: String, val route: String, val icon: Int) {
    object LocalCabinet: BottomNavigationItems("Local Cabinet", "", 3421)
    object MainScreen: BottomNavigationItems("Local Cabinet", "", 3421)
    object LoginScreen: BottomNavigationItems("Local Cabinet", "", 3421)
}
