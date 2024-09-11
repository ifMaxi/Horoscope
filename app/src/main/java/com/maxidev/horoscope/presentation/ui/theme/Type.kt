package com.maxidev.horoscope.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.maxidev.horoscope.R

val nunitoFamily = FontFamily(
    Font(R.font.nunito_light, weight = FontWeight.Light),
    Font(R.font.nunito, weight = FontWeight.Normal),
    Font(R.font.nunito_medium, weight = FontWeight.Medium)
)

val quickSandFamily = FontFamily(
    Font(R.font.quicksand_medium, weight = FontWeight.Medium),
    Font(R.font.quicksand_semibold, weight = FontWeight.SemiBold)
)

val macondoFamily = FontFamily(
    Font(R.font.macondo, weight = FontWeight.Normal)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = nunitoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)