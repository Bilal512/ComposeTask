package com.example.composetask.di

import com.example.composetask.data.api.ApiInterface
import com.example.composetask.data.repo.DataRepoImpl
import com.example.composetask.domain.repo.DataRepo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@InstallIn(ViewModelComponent::class)
@Module
object RepoModule {

    @Provides
    fun provideDataRepo(apiInterface: ApiInterface): DataRepo = DataRepoImpl(apiInterface)

    @Provides
    fun provideGson() = Gson()
}