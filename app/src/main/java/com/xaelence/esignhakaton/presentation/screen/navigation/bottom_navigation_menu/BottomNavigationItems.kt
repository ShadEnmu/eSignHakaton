package com.xaelence.esignhakaton.presentation.screen.navigation.bottom_navigation_menu

import com.xaelence.esignhakaton.R

sealed class BottomNavigationItems(val name: String, val route: String, val icon: Int) {
    data object LocalCabinet: BottomNavigationItems("Профиль", "local_cabinet", R.drawable.ic_user_icon)
    data object MainScreen: BottomNavigationItems("Документы", "main_screen", R.drawable.ic_main_icon)
}
