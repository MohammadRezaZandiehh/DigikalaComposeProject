package com.example.digikalacomposeproject.di

import com.example.digikalacomposeproject.data.remote.CategoryApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CategoryApiInterfaceModule {

    @Singleton
    @Provides
    fun provideHomeApiService(retrofit: Retrofit) : CategoryApiInterface =
        retrofit.create(CategoryApiInterface::class.java)

}