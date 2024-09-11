package com.maxidev.horoscope.di

import android.content.Context
import com.maxidev.horoscope.data.datastore.OnBoardDataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun providesOnBoardingDataStore(
        @ApplicationContext context: Context
    ) = OnBoardDataStoreRepository(context)
}