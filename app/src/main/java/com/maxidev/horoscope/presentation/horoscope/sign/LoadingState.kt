package com.maxidev.horoscope.presentation.horoscope.sign

import androidx.compose.runtime.Immutable
import com.maxidev.horoscope.domain.model.HoroscopeDTO

@Immutable
sealed interface LoadingState {
    data class Success(val onSuccess: HoroscopeDTO): LoadingState
    data class Error(val onError: Exception): LoadingState
    data object Loading: LoadingState
}