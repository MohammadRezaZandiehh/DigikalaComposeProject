package com.example.digikalacomposeproject.di

import com.example.digikalacomposeproject.data.remote.HomeApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeApiInterfaceModule {

    @Provides
    @Singleton
    fun provideHomeApiService(retrofit: Retrofit): HomeApiInterface =
        retrofit.create(HomeApiInterface::class.java)
}


/** internal fun: use these fun just in its class. (or object or interface ...)*/




