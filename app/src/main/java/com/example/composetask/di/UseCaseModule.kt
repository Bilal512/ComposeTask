package com.example.composetask.di

import com.example.composetask.domain.usecase.GreetingsUseCase
import com.example.composetask.domain.usecase.ValidateEmailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object UseCaseModule {

    @Provides
    fun provideGreetingsUseCase(): GreetingsUseCase {
        return GreetingsUseCase()
    }

    @Provides
    fun provideEmailValidationUseCase() = ValidateEmailUseCase()
}