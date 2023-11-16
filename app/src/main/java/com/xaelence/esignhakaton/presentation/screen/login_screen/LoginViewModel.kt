package com.xaelence.esignhakaton.presentation.screen.login_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.xaelence.esignhakaton.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

) : ViewModel() {
    private val state: MutableState<LoginScreenDataState> = mutableStateOf(LoginScreenDataState())
    var _state = state

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.Authorize -> {
                state.value = state.value.copy(
                    screenState = if (event.login.isNotEmpty() && event.password.isNotEmpty()) LoginScreenState.Accept else LoginScreenState.Error
                )
            }

            is LoginEvent.Decline -> {
                state.value = state.value.copy(
                    screenState = LoginScreenState.Error
                )
            }
        }
    }
}