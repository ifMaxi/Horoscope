package com.maxidev.horoscope

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.maxidev.horoscope.data.broadcast.AlarmNotification
import com.maxidev.horoscope.data.broadcast.AlarmNotification.Companion.NOTIFICATION_ID
import com.maxidev.horoscope.navigation.NavigationGraph
import com.maxidev.horoscope.presentation.horoscope.onboarding.SplashViewModel
import com.maxidev.horoscope.presentation.ui.theme.DailyHoroscopeTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition {
            !splashViewModel.isLoading.value
        }
        enableEdgeToEdge()
        scheduleNotification()
        setContent {
            DailyHoroscopeTheme(dynamicColor = false) {
                val navController = rememberNavController()
                val screen by splashViewModel.startDestination

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationGraph(
                        navController = navController,
                        startDestination = screen,
                        modifier = Modifier.consumeWindowInsets(innerPadding),
                    )
                }
            }
        }
    }

    private fun scheduleNotification() {
        val intent = Intent(applicationContext, AlarmNotification::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            NOTIFICATION_ID,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val calendar = Calendar.getInstance()
            .apply {
                timeInMillis = System.currentTimeMillis()
                set(Calendar.HOUR_OF_DAY, 10)
                set(Calendar.MINUTE, 0)
            }
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
    }

    companion object {
        const val MY_CHANNEL_ID = "alarm_notification_channel"
    }
}