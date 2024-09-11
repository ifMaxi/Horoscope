package com.maxidev.horoscope.domain.model

data class HoroscopeDTO(
    val daily: DailyDTO,
    val weekly: WeeklyDTO,
    val monthly: MonthlyDTO
)