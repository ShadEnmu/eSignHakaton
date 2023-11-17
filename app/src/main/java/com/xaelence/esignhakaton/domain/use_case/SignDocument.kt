package com.xaelence.esignhakaton.domain.use_case

import com.xaelence.esignhakaton.domain.utils.ESigner
import java.io.File
import java.security.PrivateKey

class SignDocument {

    operator fun invoke(privateKey: PrivateKey, document: File) {
        ESigner(privateKey, document).sign()
    }
}