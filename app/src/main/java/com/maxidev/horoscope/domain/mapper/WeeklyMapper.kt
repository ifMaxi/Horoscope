package com.maxidev.horoscope.domain.mapper

import com.maxidev.horoscope.data.remote.model.WeeklyNetwork
import com.maxidev.horoscope.domain.model.WeeklyDTO

fun WeeklyNetwork.asDomain() =
    this.data.let { data ->
        WeeklyDTO(
            horoscopeData = data.horoscopeData,
            week = data.week
        )
    }