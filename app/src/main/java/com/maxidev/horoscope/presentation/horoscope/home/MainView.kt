package com.maxidev.horoscope.presentation.horoscope.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.maxidev.horoscope.R
import com.maxidev.horoscope.navigation.Destinations
import com.maxidev.horoscope.presentation.ui.theme.gradientBackgroundDark
import com.maxidev.horoscope.presentation.ui.theme.gradientBackgroundLight
import com.maxidev.horoscope.presentation.ui.theme.macondoFamily
import com.maxidev.horoscope.presentation.ui.theme.nunitoFamily
import com.maxidev.horoscope.utils.SignUtils

@Composable
fun MainView(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val signs = SignUtils.signs

    SignList(
        modifier = modifier,
        model = signs,
        onClick = { sign -> navController.navigate(Destinations.SignScreen(sign = sign)) },
        contentPadding = WindowInsets.systemBars.asPaddingValues()
    )
}

@Composable
private fun SignList(
    modifier: Modifier = Modifier,
    model: List<Signs>,
    lazyState: LazyListState = rememberLazyListState(),
    onClick: (String) -> Unit,
    contentPadding: PaddingValues
) {
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
        verticalArrangement = Arrangement.SpaceEvenly,
        contentPadding = contentPadding
    ) {
        item {
            TopIconItem()
        }
        items(
            items = model,
            key = { it.sign },
            contentType = { it.sign }
        ) { item ->
            SignItem(
                image = item.image,
                sign = item.sign,
                dateRange = item.date,
                onClick = { onClick(item.signName) }
            )
        }
    }
}

@Composable
private fun TopIconItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(R.drawable.astrology),
            contentDescription = "Astrology",
            modifier = Modifier
                .size(54.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = "Horoscope",
            fontSize = 40.sp,
            fontFamily = macondoFamily
        )
    }
}

@Composable
private fun SignItem(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    @StringRes sign: Int,
    dateRange: String,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(120.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(20),
        elevation = CardDefaults.cardElevation(8.dp),
        border = BorderStroke(
            width = 4.dp,
            color = MaterialTheme.colorScheme.outline
        ),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = stringResource(id = sign),
                modifier = Modifier
                    .padding(10.dp)
                    .size(100.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = stringResource(id = sign),
                    fontSize = 20.sp,
                    fontFamily = macondoFamily,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Text(
                    text = "($dateRange)",
                    fontFamily = nunitoFamily,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}