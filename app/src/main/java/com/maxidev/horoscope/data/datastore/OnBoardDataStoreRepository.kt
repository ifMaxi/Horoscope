package com.maxidev.horoscope.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

private const val ONBOARD_PREFERENCE = "onboard_preference"
private const val ONBOARD_COMPLETE = "onboard_complete"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = ONBOARD_PREFERENCE)

class OnBoardDataStoreRepository(context: Context) {

    private object PreferenceKey {
        val onBoardingKey = booleanPreferencesKey(name = ONBOARD_COMPLETE)
    }

    private val dataStore = context.dataStore

    suspend fun saveOnBoardingState(complete: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferenceKey.onBoardingKey] = complete
        }
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else throw exception
            }
            .map { preference ->
                val onBoardingState = preference[PreferenceKey.onBoardingKey] ?: false
                onBoardingState
            }
    }
}