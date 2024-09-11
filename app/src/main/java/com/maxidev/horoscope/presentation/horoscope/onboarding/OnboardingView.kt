package com.maxidev.horoscope.presentation.horoscope.onboarding

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.maxidev.horoscope.R
import com.maxidev.horoscope.navigation.Destinations
import com.maxidev.horoscope.presentation.horoscope.components.LottieComponent
import com.maxidev.horoscope.presentation.ui.theme.gradientBackgroundDark
import com.maxidev.horoscope.presentation.ui.theme.gradientBackgroundLight
import com.maxidev.horoscope.presentation.ui.theme.nunitoFamily
import com.maxidev.horoscope.presentation.ui.theme.quickSandFamily
import kotlinx.coroutines.launch

@Composable
fun OnboardingView(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: OnBoardingViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { 3 })
    val darkModeBrush = Brush.verticalGradient(gradientBackgroundDark)
    val lightModeBrush = Brush.verticalGradient(gradientBackgroundLight)
    val context = LocalContext.current
    var hasNotificationPermission by remember {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            mutableStateOf(
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED
            )
        } else mutableStateOf(true)
    }
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted -> hasNotificationPermission = isGranted }
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush = if (isSystemInDarkTheme()) darkModeBrush else lightModeBrush),
        contentAlignment = Alignment.Center
    ) {
        HorizontalPager(
            modifier = Modifier,
            state = pagerState,
            contentPadding = WindowInsets.statusBars.asPaddingValues()
        ) { page ->
            when (page) {
                0 -> {
                    OnboardingComponent(
                        animation = R.raw.zodiac_circle,
                        text = R.string.onboard_one
                    )
                }

                1 -> {
                    OnboardingComponent(
                        animation = R.raw.daily_calendar,
                        text = R.string.onboard_two
                    )
                }

                2 -> {
                    OnboardingComponent(
                        animation = R.raw.horoscope_globe,
                        text = R.string.onboard_three
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(WindowInsets.systemBars.asPaddingValues()),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    if (pagerState.currentPage <= 1) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                        }
                        viewModel.saveOnBoardingState(true)
                        navController.popBackStack()
                        navController.navigate(Destinations.MainScreen)
                    }
                },
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = if (pagerState.currentPage == 2) "Finish" else "Next",
                    fontFamily = nunitoFamily
                )
            }
        }
    }
}

@Composable
private fun OnboardingComponent(
    modifier: Modifier = Modifier,
    @RawRes animation: Int,
    @StringRes text: Int
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LottieComponent(
            animation = animation,
            size = 240.dp
        )
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = stringResource(text),
            fontSize = 20.sp,
            fontFamily = quickSandFamily,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            lineHeight = 36.sp,
            modifier = Modifier
                .padding(20.dp)
        )
    }
}