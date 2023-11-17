package com.xaelence.esignhakaton.presentation.screen.local_cabinet

sealed class LocalCabinetEvent {
    data object GenerateKeys: LocalCabinetEvent()
}