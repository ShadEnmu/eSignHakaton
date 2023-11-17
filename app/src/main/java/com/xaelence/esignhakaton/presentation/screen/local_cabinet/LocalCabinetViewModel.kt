package com.xaelence.esignhakaton.presentation.screen.local_cabinet

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.xaelence.esignhakaton.domain.use_case.ESignUseCases
import com.xaelence.esignhakaton.domain.utils.KeyManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocalCabinetViewModel @Inject constructor(
    private val keyManager: KeyManager
) : ViewModel() {
    private val state: MutableState<LocalCabinetDataState> = mutableStateOf(LocalCabinetDataState())
    var _state = state
    private val alias = "secret3v"
    init {
        if (keyManager.isKeyExist(alias)) {
            state.value = state.value.copy(
                privateKey = keyManager.getPrivateKey(alias),
                publicKey = keyManager.getPublicKey(alias)
            )
        }
    }

    fun onEvent(event: LocalCabinetEvent) {
        when (event) {
            LocalCabinetEvent.GenerateKeys -> {
                keyManager.generateKeyPair(alias)
                state.value = state.value.copy(
                    privateKey = keyManager.getPrivateKey(alias),
                    publicKey = keyManager.getPublicKey(alias)
                )
            }
        }
    }
}