package com.maxidev.horoscope.presentation.horoscope.sign

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class Sign(
    @DrawableRes val image: Int,
    @DrawableRes val icon: Int,
    val signName: String,
)