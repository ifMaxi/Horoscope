package com.maxidev.horoscope.presentation.horoscope.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxidev.horoscope.data.datastore.OnBoardDataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val dataStore: OnBoardDataStoreRepository
): ViewModel() {

    fun saveOnBoardingState(complete: Boolean) {
        viewModelScope.launch(IO) {
            dataStore.saveOnBoardingState(complete)
        }
    }
}