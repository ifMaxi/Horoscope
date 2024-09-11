package com.maxidev.horoscope.presentation.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = darkPrimary,
    onPrimary = darkOnPrimary,
    primaryContainer = darkPrimaryContainer,
    onPrimaryContainer = darkOnPrimaryContainer,
    inversePrimary = darkInversePrimary,

    secondary = darkSecondary,
    onSecondary = darkOnSecondary,
    secondaryContainer = darkSecondaryContainer,
    onSecondaryContainer = darkOnSecondaryContainer,

    tertiary = darkTertiary,
    onTertiary = darkOnTertiary,
    tertiaryContainer = darkTertiaryContainer,
    onTertiaryContainer = darkOnTertiaryContainer,

    background = darkBackground,
    onBackground = darkOnBackground,
    surface = darkSurface,
    onSurface = darkOnSurface,
    surfaceVariant = darkSurfaceVariant,
    onSurfaceVariant = darkOnSurfaceVariant,
    surfaceTint = darkSurfaceTint,

    inverseSurface = darkInverseSurface,
    inverseOnSurface = darkInverseOnSurface,
    error = darkError,
    onError = darkOnError,
    errorContainer = darkErrorContainer,
    onErrorContainer = darkOnErrorContainer,

    outline = darkOutline,
    outlineVariant = darkOutlineVariant,
    scrim = darkScrim,

    surfaceBright = darkSurfaceBright,
    surfaceContainer = darkSurfaceContainer,
    surfaceContainerHigh = darkSurfaceContainerHigh,
    surfaceContainerHighest =  darkSurfaceContainerHighest,
    surfaceContainerLow = darkSurfaceContainerLow,
    surfaceContainerLowest = darkSurfaceContainerLowest,
    surfaceDim = darkSurfaceDim
)

private val LightColorScheme = lightColorScheme(
    primary =lightPrimary,
    onPrimary = lightOnPrimary,
    primaryContainer = lightPrimaryContainer,
    onPrimaryContainer = lightOnPrimaryContainer,
    inversePrimary = lightInversePrimary,

    secondary = lightSecondary,
    onSecondary = lightOnSecondary,
    secondaryContainer = lightSecondaryContainer,
    onSecondaryContainer = lightOnSecondaryContainer,

    tertiary =  lightTertiary,
    onTertiary = lightOnTertiary,
    tertiaryContainer = lightTertiaryContainer,
    onTertiaryContainer = lightOnTertiaryContainer,

    background = lightBackground,
    onBackground = lightOnBackground,
    surface = lightSurface,
    onSurface = lightOnSurface,
    surfaceVariant = lightSurfaceVariant,
    onSurfaceVariant = lightOnSurfaceVariant,
    surfaceTint = lightSurfaceTint,

    inverseSurface = lightInverseSurface,
    inverseOnSurface = lightInverseOnSurface,
    error = lightError,
    onError = lightOnError,
    errorContainer = lightErrorContainer,
    onErrorContainer = lightOnErrorContainer,

    outline = lightOutline,
    outlineVariant = lightOutlineVariant,
    scrim = lightScrim,

    surfaceBright = lightSurfaceBright,
    surfaceContainer = lightSurfaceContainer,
    surfaceContainerHigh = lightSurfaceContainerHigh,
    surfaceContainerHighest = lightSurfaceContainerHighest,
    surfaceContainerLow = lightSurfaceContainerLow,
    surfaceContainerLowest = lightSurfaceContainerLowest,
    surfaceDim = lightSurfaceDim
)

@Composable
fun DailyHoroscopeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}