package com.maxidev.horoscope.data.impl

import com.maxidev.horoscope.data.remote.ApiHelper
import com.maxidev.horoscope.di.IoDispatcher
import com.maxidev.horoscope.domain.mapper.asDomain
import com.maxidev.horoscope.domain.model.HoroscopeDTO
import com.maxidev.horoscope.domain.repository.HoroscopeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HoroscopeRepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
): HoroscopeRepository {

    override suspend fun getHoroscopeStream(sign: String): HoroscopeDTO {

        return withContext(ioDispatcher) {

            val responseDaily = apiHelper.fetchDailyHoroscope(sign).asDomain()
            val responseWeekly = apiHelper.fetchWeeklyHoroscope(sign).asDomain()
            val responseMonthly = apiHelper.fetchMonthlyHoroscope(sign).asDomain()

            HoroscopeDTO(
                daily = responseDaily,
                weekly = responseWeekly,
                monthly = responseMonthly
            )
        }
    }
}