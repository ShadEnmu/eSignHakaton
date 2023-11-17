package com.xaelence.esignhakaton.domain.utils

import java.io.File
import java.security.PublicKey
import java.security.Signature

class EVerifier(private val publicKey: PublicKey, private val document: File, private val signature: ByteArray) {

    fun verify(): Boolean {
        val signatureVerify = Signature.getInstance("SHA256withRSA", "BC")
        signatureVerify.initVerify(publicKey)
        signatureVerify.update(document.readBytes())
        return signatureVerify.verify(signature)
    }

}