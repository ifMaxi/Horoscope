package com.maxidev.horoscope.domain.mapper

import com.maxidev.horoscope.data.remote.model.MonthlyNetwork
import com.maxidev.horoscope.domain.model.MonthlyDTO

fun MonthlyNetwork.asDomain() =
    this.data.let { data ->
        MonthlyDTO(
            horoscopeData = data.horoscopeData,
            month = data.month
        )
    }