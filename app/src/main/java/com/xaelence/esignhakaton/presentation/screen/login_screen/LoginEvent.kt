package com.xaelence.esignhakaton.presentation.screen.login_screen

sealed class LoginEvent {
    data class Authorize(val login: String, val password: String) : LoginEvent()
    class Decline(private val error: String): LoginEvent()
}