package com.xaelence.esignhakaton.presentation.screen.login_screen

sealed class LoginScreenState {
    data object InProcess: LoginScreenState()
    data object Error: LoginScreenState()
    data object Accept: LoginScreenState()
}