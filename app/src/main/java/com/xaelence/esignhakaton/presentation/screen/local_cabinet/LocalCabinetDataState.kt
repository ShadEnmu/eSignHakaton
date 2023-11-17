package com.xaelence.esignhakaton.presentation.screen.local_cabinet

import com.xaelence.esignhakaton.domain.model.FileInfo
import java.security.PrivateKey
import java.security.PublicKey

data class LocalCabinetDataState (
    val privateKey: PrivateKey? = null,
    val publicKey: PublicKey? = null,
    val historyList: List<FileInfo> = listOf()
)