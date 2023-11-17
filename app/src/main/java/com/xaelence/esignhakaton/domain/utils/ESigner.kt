package com.xaelence.esignhakaton.domain.utils

import android.util.Log
import java.io.File
import java.io.FileWriter
import java.security.PrivateKey
import java.security.Signature

class ESigner(private val privateKey: PrivateKey, private val document: File) {

    fun sign() {
        val signature = Signature.getInstance("SHA256withRSA", "BC")
        signature.initSign(privateKey)
        signature.update(document.readBytes())
        val signatureBytes = signature.sign()
        Log.d("dev", "signDocument: Success")
        FileWriter("signed${document.name}").use {
            it.write(document.readBytes().decodeToString())
        }
    }
}