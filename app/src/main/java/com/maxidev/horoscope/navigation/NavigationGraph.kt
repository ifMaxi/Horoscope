package com.maxidev.horoscope.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.maxidev.horoscope.presentation.horoscope.home.MainView
import com.maxidev.horoscope.presentation.horoscope.onboarding.OnboardingView
import com.maxidev.horoscope.presentation.horoscope.sign.DailyView
import kotlinx.serialization.Serializable

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: Destinations
) {
    NavHost(
        modifier = modifier,
        startDestination = startDestination,
        navController = navController
    ) {
        composable<Destinations.OnboardingScreen> {
            OnboardingView(navController = navController)
        }
        composable<Destinations.MainScreen> {
            MainView(navController = navController)
        }
        composable<Destinations.SignScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<Destinations.SignScreen>()

            DailyView(sign = args.sign)
        }
    }
}

@Serializable
sealed class Destinations {
    @Serializable data object OnboardingScreen : Destinations()
    @Serializable data object MainScreen: Destinations()
    @Serializable data class SignScreen(val sign: String): Destinations()
}