package com.example.romanconverter.di

import com.example.romanconverter.domain.use_cases.RomanConverterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun getRomanConverterUseCase(): RomanConverterUseCase {
        return RomanConverterUseCase()
    }
}