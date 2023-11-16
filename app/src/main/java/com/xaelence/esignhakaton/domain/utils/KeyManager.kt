package com.xaelence.esignhakaton.domain.utils

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.security.PrivateKey
import java.security.PublicKey
import java.security.cert.Certificate

class KeyManager (private val keyStoreFile: File) {
    private val keyStore: KeyStore = KeyStore.getInstance("PKCS12")

    init {
        if (keyStoreFile.exists()) {
            FileInputStream(keyStoreFile).use {
                keyStore.load(it, null)
            }
        }
        else {
            keyStore.load(null, null)
            keyStore.store(FileOutputStream(keyStoreFile), null)
        }
    }

    fun generateKeyPair(alias: String) {
        val keyPairGenerator: KeyPairGenerator = KeyPairGenerator.getInstance("RSA")
        keyPairGenerator.initialize(2048)
        val keyPair = keyPairGenerator.generateKeyPair()

        val privateKey = keyPair.private
        val publicKey = keyPair.public

        // Сохранение закрытого ключа в KeyStore
        keyStore.setKeyEntry(alias, privateKey, null, arrayOf(publicKey as Certificate))

        keyStore.store(FileOutputStream(keyStoreFile), null)
    }

    fun getPrivateKey(alias: String): PrivateKey? {
        return keyStore.getKey(alias, null) as? PrivateKey
    }

    fun getPublicKey(alias: String): PublicKey? {
        return keyStore.getCertificate(alias) as? PublicKey
    }
}