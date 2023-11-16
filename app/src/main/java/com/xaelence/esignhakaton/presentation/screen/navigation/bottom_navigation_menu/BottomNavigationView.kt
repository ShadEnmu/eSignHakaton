package com.xaelence.esignhakaton.presentation.screen.navigation.bottom_navigation_menu

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.xaelence.esignhakaton.ui.theme.DeepBlue
import com.xaelence.esignhakaton.ui.theme.Gray

@Composable
fun BottomNavigationView(navController: NavHostController) {
    BottomNavigation(
        backgroundColor = Color.White, contentColor = Gray
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val bottomNavigationItems = listOf(
            BottomNavigationItems.MainScreen,
            BottomNavigationItems.LocalCabinet
        )

        bottomNavigationItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                selectedContentColor = DeepBlue,
                unselectedContentColor = Color.DarkGray,
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.name
                    )
                },
                label = {
                    Text(text = item.name)
                },
                alwaysShowLabel = false
            )
        }
    }
}