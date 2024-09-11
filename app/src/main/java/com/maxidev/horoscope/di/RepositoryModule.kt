package com.maxidev.horoscope.di

import com.maxidev.horoscope.data.impl.HoroscopeRepositoryImpl
import com.maxidev.horoscope.domain.repository.HoroscopeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindDailyRepository(impl: HoroscopeRepositoryImpl): HoroscopeRepository
}