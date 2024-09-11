package com.maxidev.horoscope.presentation.horoscope.sign

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.maxidev.horoscope.R
import com.maxidev.horoscope.domain.model.HoroscopeDTO
import com.maxidev.horoscope.presentation.ui.theme.gradientBackgroundDark
import com.maxidev.horoscope.presentation.ui.theme.gradientBackgroundLight
import com.maxidev.horoscope.presentation.ui.theme.macondoFamily
import com.maxidev.horoscope.utils.SignUtils

private val regex = "(?<=[.!?])\\s*".toRegex()

@Composable
fun DailyView(
    modifier: Modifier = Modifier,
    viewModel: HoroscopeViewModel = hiltViewModel(),
    sign: String
) {
    val screenState = viewModel.loadingState.collectAsStateWithLifecycle()
    val scrollState = rememberLazyListState()
    val signs = SignUtils.signsDaily

    LaunchedEffect(String) {
        viewModel.parallelStream(sign)
    }

    signs.forEach { item ->
        if (sign == item.signName) {
            ViewLoading(
                modifier = modifier,
                loadingState = screenState.value,
                image = item.image,
                icon = item.icon,
                sign = item.signName,
                scrollState = scrollState,
                contentPadding = WindowInsets.systemBars.asPaddingValues()
            )
        }
    }
}

@Composable
private fun ViewLoading(
    modifier: Modifier = Modifier,
    loadingState: LoadingState,
    @DrawableRes image: Int,
    @DrawableRes icon: Int,
    sign: String,
    scrollState: LazyListState,
    contentPadding: PaddingValues
) {

    when (loadingState) {
        is LoadingState.Error -> {
            LoadingStateScreen(
                image = R.drawable.black_hole,
                status = "We had a little problem with the server,\nplease try again later.\uD83D\uDE05"
            )
        }
        LoadingState.Loading -> {
            LoadingStateScreen(image = R.drawable.horoscope, status = null)
        }
        is LoadingState.Success -> {
            DailyItem(
                modifier = modifier,
                horoscope = loadingState.onSuccess,
                image = image,
                icon = icon,
                sign = sign,
                lazyState = scrollState,
                contentPadding = contentPadding
            )
        }
    }
}

@Composable
private fun DailyItem(
    modifier: Modifier = Modifier,
    horoscope: HoroscopeDTO,
    @DrawableRes image: Int,
    @DrawableRes icon: Int,
    sign: String,
    lazyState: LazyListState,
    contentPadding: PaddingValues
) {
    val tabList = listOf("Daily", "Weekly", "Monthly")
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }
    val lineHeight = 24.sp
    val darkModeBrush = Brush.verticalGradient(gradientBackgroundDark)
    val lightModeBrush = Brush.verticalGradient(gradientBackgroundLight)

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = if (isSystemInDarkTheme()) darkModeBrush else lightModeBrush
            ),
        state = lazyState,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp),
        contentPadding = contentPadding
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = sign,
                    fontSize = 30.sp,
                    fontFamily = macondoFamily,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(20.dp))
                Image(
                    painter = painterResource(icon),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }
        item {
            Image(
                painter = painterResource(image),
                contentDescription = sign,
                modifier = Modifier
                    .size(360.dp)
            )
        }
        item {
            TabRow(
                modifier = Modifier,
                selectedTabIndex = selectedIndex,
                containerColor = Color.Transparent
            ) {
                tabList.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        text = {
                            Text(
                                text = title,
                                fontFamily = macondoFamily,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onSurface,
                            )
                        }
                    )
                }
            }

            when (selectedIndex) {
                0 -> {
                    Text(
                        text = buildHoroscopeText(
                            title = horoscope.daily.date,
                            content = horoscope.daily.horoscopeData,
                            regex = regex
                        ),
                        textAlign = TextAlign.Center,
                        lineHeight = lineHeight,
                        modifier = Modifier.padding(20.dp)
                    )
                }
                1 -> {
                    Text(
                        text = buildHoroscopeText(
                            title = horoscope.weekly.week,
                            content = horoscope.weekly.horoscopeData,
                            regex = regex
                        ),
                        textAlign = TextAlign.Center,
                        lineHeight = lineHeight,
                        modifier = Modifier.padding(20.dp)
                    )
                }
                2 -> {
                    Text(
                        text = buildHoroscopeText(
                            title = horoscope.monthly.month,
                            content = horoscope.monthly.horoscopeData,
                            regex = regex
                        ),
                        textAlign = TextAlign.Center,
                        lineHeight = lineHeight,
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
        }
    }
}

@Suppress("SameParameterValue")
private fun buildHoroscopeText(title: String, content: String, regex: Regex): AnnotatedString =
    buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold,
                fontFamily = macondoFamily,
                fontSize = 22.sp
            )
        ) { append("$title\n\n") }
        append(content.replace(regex, "\n\n"))
    }