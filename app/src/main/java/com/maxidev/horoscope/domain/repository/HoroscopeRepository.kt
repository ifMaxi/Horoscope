package com.maxidev.horoscope.domain.repository

import com.maxidev.horoscope.domain.model.HoroscopeDTO

interface HoroscopeRepository {

    suspend fun getHoroscopeStream(sign: String): HoroscopeDTO
}