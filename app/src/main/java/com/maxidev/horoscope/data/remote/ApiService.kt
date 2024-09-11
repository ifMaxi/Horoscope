package com.maxidev.horoscope.data.remote

import com.maxidev.horoscope.data.remote.model.DailyNetwork
import com.maxidev.horoscope.data.remote.model.MonthlyNetwork
import com.maxidev.horoscope.data.remote.model.WeeklyNetwork
import com.maxidev.horoscope.utils.Constants.DAILY_HOROSCOPE
import com.maxidev.horoscope.utils.Constants.MONTHLY_HOROSCOPE
import com.maxidev.horoscope.utils.Constants.WEEKLY_HOROSCOPE
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(DAILY_HOROSCOPE)
    suspend fun getDailyHoroscope(
        @Query("sign") sign: String,
        @Query("day") day: String = "TODAY"
    ): DailyNetwork

    @GET(WEEKLY_HOROSCOPE)
    suspend fun getWeeklyHoroscope(
        @Query("sign") sign: String
    ): WeeklyNetwork

    @GET(MONTHLY_HOROSCOPE)
    suspend fun getMonthlyHoroscope(
        @Query("sign") sign: String
    ): MonthlyNetwork
}