package com.maxidev.horoscope.presentation.horoscope.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable

@Immutable
data class Signs(
    @DrawableRes val image: Int,
    @StringRes val sign: Int,
    val signName: String,
    val date: String
)