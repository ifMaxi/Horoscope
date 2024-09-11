package com.maxidev.horoscope.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyNetwork(
    val data: Data = Data(),
    val status: Int = 0,
    val success: Boolean = false
) {
    @Serializable
    data class Data(
        val date: String = "",
        @SerialName("horoscope_data")
        val horoscopeData: String = ""
    )
}