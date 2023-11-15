package com.xaelence.esignhakaton.presentation.screen.login_screen

sealed class LoginEvent {
    class Authorize(private val login: String, private val password: String): LoginEvent()
    class Decline(private val error: String): LoginEvent()
    class InvalidData(private val error: String): LoginEvent()
}