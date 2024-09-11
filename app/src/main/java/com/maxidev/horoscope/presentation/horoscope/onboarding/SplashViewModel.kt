package com.maxidev.horoscope.presentation.horoscope.onboarding

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxidev.horoscope.data.datastore.OnBoardDataStoreRepository
import com.maxidev.horoscope.navigation.Destinations
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val dataStore: OnBoardDataStoreRepository
): ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<Destinations> =
        mutableStateOf(Destinations.OnboardingScreen)
    val startDestination: State<Destinations> = _startDestination

    init {
        viewModelScope.launch {
            dataStore.readOnBoardingState().collect { completed ->
                if (completed) {
                    _startDestination.value = Destinations.MainScreen
                } else {
                    _startDestination.value = Destinations.OnboardingScreen
                }
            }
            _isLoading.value = false
        }
    }
}