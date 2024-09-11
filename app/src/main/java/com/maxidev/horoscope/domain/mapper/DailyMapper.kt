package com.maxidev.horoscope.domain.mapper

import com.maxidev.horoscope.data.remote.model.DailyNetwork
import com.maxidev.horoscope.domain.model.DailyDTO

fun DailyNetwork.asDomain() =
    this.data.let { data ->
        DailyDTO(
            date = data.date,
            horoscopeData = data.horoscopeData
        )
    }