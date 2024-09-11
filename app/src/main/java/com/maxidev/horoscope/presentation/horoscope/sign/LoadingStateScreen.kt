package com.maxidev.horoscope.presentation.horoscope.sign

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxidev.horoscope.presentation.ui.theme.gradientBackgroundDark
import com.maxidev.horoscope.presentation.ui.theme.gradientBackgroundLight

@Composable
fun LoadingStateScreen(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    status: String?
) {
    val darkModeBrush = Brush.verticalGradient(gradientBackgroundDark)
    val lightModeBrush = Brush.verticalGradient(gradientBackgroundLight)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = if (isSystemInDarkTheme()) darkModeBrush else lightModeBrush
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = status ?: "",
            fontSize = 18.sp,
            maxLines = 2,
            lineHeight = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}