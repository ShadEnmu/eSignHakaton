package com.xaelence.esignhakaton.domain.use_case

import com.xaelence.esignhakaton.domain.utils.EVerifier
import java.io.File
import java.security.PublicKey

class VerifyDocument {

    operator fun invoke(publicKey: PublicKey, document: File, signature: ByteArray): Boolean {
        return EVerifier(publicKey, document, signature).verify()
    }
}