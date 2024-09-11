package com.maxidev.horoscope.presentation.horoscope.sign

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxidev.horoscope.domain.repository.HoroscopeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(
    private val repository: HoroscopeRepository
): ViewModel() {

    private val _loadingState: MutableStateFlow<LoadingState> =
        MutableStateFlow(LoadingState.Loading)
    val loadingState: StateFlow<LoadingState> = _loadingState.asStateFlow()

    fun parallelStream(sign: String) = viewModelScope.launch {
        _loadingState.value = LoadingState.Loading

        _loadingState.value = try {
            LoadingState.Success(onSuccess = repository.getHoroscopeStream(sign))
        } catch (e: HttpException) {
            LoadingState.Error(onError = e)
        } catch (e: IOException) {
            LoadingState.Error(onError = e)
        }
    }
}