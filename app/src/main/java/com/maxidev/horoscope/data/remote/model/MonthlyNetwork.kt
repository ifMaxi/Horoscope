package com.maxidev.horoscope.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MonthlyNetwork(
    val data: Data = Data(),
    val status: Int = 0,
    val success: Boolean = false
) {
    @Serializable
    data class Data(
        @SerialName("challenging_days")
        val challengingDays: String = "",
        @SerialName("horoscope_data")
        val horoscopeData: String = "",
        val month: String = "",
        @SerialName("standout_days")
        val standoutDays: String = ""
    )
}