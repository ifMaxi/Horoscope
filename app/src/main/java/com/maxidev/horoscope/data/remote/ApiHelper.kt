package com.maxidev.horoscope.data.remote

import javax.inject.Inject

class ApiHelper @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun fetchDailyHoroscope(sign: String) = apiService.getDailyHoroscope(sign)

    suspend fun fetchWeeklyHoroscope(sign: String) = apiService.getWeeklyHoroscope(sign)

    suspend fun fetchMonthlyHoroscope(sign: String) = apiService.getMonthlyHoroscope(sign)
}