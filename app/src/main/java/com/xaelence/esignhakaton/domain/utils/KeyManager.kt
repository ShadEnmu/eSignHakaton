package com.xaelence.esignhakaton.domain.utils

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Log
import org.conscrypt.Conscrypt
import java.math.BigInteger
import java.nio.charset.Charset
import java.security.KeyFactory
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.security.PrivateKey
import java.security.PublicKey
import java.security.Security
import java.security.spec.X509EncodedKeySpec
import java.util.Base64
import java.util.Base64.Decoder
import java.util.Date
import javax.security.auth.x500.X500Principal

class KeyManager {

    init {
        Security.insertProviderAt(Conscrypt.newProvider(), 1)
    }

    fun generateKeyPair(alias: String) {
        val keyStore = KeyStore.getInstance("AndroidKeyStore")
        keyStore.load(null)

        val keyPairGenerator: KeyPairGenerator =
            KeyPairGenerator.getInstance(KeyProperties.KEY_ALGORITHM_RSA, "AndroidKeyStore")
        val keyGenParameterSpec = KeyGenParameterSpec.Builder(
            alias,
            KeyProperties.PURPOSE_SIGN or KeyProperties.PURPOSE_VERIFY
        )
            .setDigests(KeyProperties.DIGEST_SHA256)
            .setSignaturePaddings(KeyProperties.SIGNATURE_PADDING_RSA_PKCS1)
            .setCertificateSubject(X500Principal("CN=$alias"))
            .setCertificateSerialNumber(BigInteger.ONE)
            .setCertificateNotBefore(Date())
            .setCertificateNotAfter(Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000))
            .build()
        keyPairGenerator.initialize(keyGenParameterSpec)
        keyPairGenerator.generateKeyPair()
    }

    fun getPrivateKey(alias: String): PrivateKey? {
        val keyStore = KeyStore.getInstance("AndroidKeyStore")
        keyStore.load(null)

        val privateKeyEntry = keyStore.getEntry(alias, null) as? KeyStore.PrivateKeyEntry
        return privateKeyEntry?.privateKey
    }

    fun getPublicKey(alias: String): PublicKey? {
        val keyStore = KeyStore.getInstance("AndroidKeyStore")
        keyStore.load(null)

        val privateKeyEntry = keyStore.getEntry(alias, null) as? KeyStore.PrivateKeyEntry
        val certificate = privateKeyEntry?.certificate

        // Вместо парсинга открытого ключа из сертификата, используем его прямо из KeyPairGenerator
        return certificate?.publicKey
    }

    fun isKeyExist(alias: String): Boolean {
        val keyStore = KeyStore.getInstance("AndroidKeyStore")
        keyStore.load(null)
        return keyStore.containsAlias(alias)
    }
}