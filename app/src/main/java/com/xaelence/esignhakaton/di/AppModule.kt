package com.xaelence.esignhakaton.di

import com.xaelence.esignhakaton.domain.use_case.ESignUseCases
import com.xaelence.esignhakaton.domain.use_case.SignDocument
import com.xaelence.esignhakaton.domain.use_case.VerifyDocument
import com.xaelence.esignhakaton.domain.utils.KeyManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideESignUseCases(keyManager: KeyManager): ESignUseCases = ESignUseCases(
        SignDocument(),
        VerifyDocument()
    )

    @Provides
    @Singleton
    fun provideKeyManager() =
        KeyManager()

    @Provides
    @Singleton
    fun provideKeyStoreFile(): File = File("secret.p12")
}