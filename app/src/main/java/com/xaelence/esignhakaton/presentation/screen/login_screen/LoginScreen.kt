package com.xaelence.esignhakaton.presentation.screen.login_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.xaelence.esignhakaton.R
import com.xaelence.esignhakaton.presentation.screen.items.CustomButton
import com.xaelence.esignhakaton.presentation.screen.items.DefaultTextInputField
import com.xaelence.esignhakaton.presentation.screen.navigation.main_navigation_graph.MainNavigationItems

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavController
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val isEmailIncorrect = remember { mutableStateOf(false) }
    val isPasswordIncorrect = remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.3f))
        DefaultTextInputField(
            text = email,
            isError = isEmailIncorrect,
            labelText = R.string.email
        )
        Spacer(modifier = Modifier.height(16.dp))
        DefaultTextInputField(
            text = password,
            isError = isPasswordIncorrect,
            labelText = R.string.password
        )
        Spacer(modifier = Modifier.height(64.dp))
        CustomButton(
            modifier = Modifier.fillMaxWidth(0.5f),
            onClick = {
                viewModel.onEvent(LoginEvent.Authorize(email.value, password.value))
                if (viewModel._state.value.screenState is LoginScreenState.Accept) navController.navigate(
                    MainNavigationItems.AppScreen.route
                )
                else {
                    isEmailIncorrect.value = true
                    isPasswordIncorrect.value = true
                }
            })
    }
}
