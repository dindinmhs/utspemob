package com.example.utspemob.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class HourlyData(val time: String, val temp: String, val imageId: Int)
data class DailyData(val day: String, val temp: String, val condition: String, val imageId: Int)

@Composable
fun CuacaScreen() {
    val placeholderImage = android.R.drawable.ic_menu_myplaces
    val placeholderStar = android.R.drawable.star_on

    val lokasi = "Berlin, Germany"
    val tanggal = "Monday, June 23"
    val suhuUtama = "24°"
    val kondisiUtama = "Partly Cloudy"
    val imageUtamaId = placeholderImage
    val highTemp = "26°C"
    val lowTemp = "18°C"
    val humidity = "62%"
    val wind = "19 km/h"
    val rain = "24%"

    val hourlyForecasts = listOf(
        HourlyData("11:00", "20°", placeholderStar),
        HourlyData("Now", "20°", placeholderStar),
        HourlyData("13:00", "21°", placeholderStar),
        HourlyData("14:00", "20°", placeholderStar),
        HourlyData("15:00", "20°", placeholderStar),
        HourlyData("16:00", "19°", placeholderStar)
    )

    val dailyForecasts = listOf(
        DailyData("Mon", "26°C", "Partly Cloudy", placeholderStar),
        DailyData("Tue", "24°C", "Showers", placeholderStar)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFF0B132B))
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(lokasi, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Medium)
            Text(tanggal, color = Color.Gray, fontSize = 14.sp)

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    painter = painterResource(id = imageUtamaId),
                    contentDescription = kondisiUtama,
                    modifier = Modifier.size(140.dp),
                    contentScale = ContentScale.Fit
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(suhuUtama, color = Color.White, fontSize = 80.sp, fontWeight = FontWeight.Bold)
                    Text(kondisiUtama, color = Color.White, fontSize = 18.sp)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WeatherInfoPill(label = "High", value = highTemp)
                WeatherInfoPill(label = "Low", value = lowTemp)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                WeatherDetailItem(label = "Humidity", value = humidity)
                WeatherDetailItem(label = "Wind", value = wind)
                WeatherDetailItem(label = "Rain", value = rain)
            }

            Spacer(modifier = Modifier.height(32.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = 8.dp)
            ) {
                items(hourlyForecasts) { forecast ->
                    HourlyForecastItem(
                        time = forecast.time,
                        temp = forecast.temp,
                        imageId = forecast.imageId,
                        isNow = forecast.time == "Now"
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
                .padding(24.dp)
        ) {
            Text(
                "7-Day Forecast",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))

            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                dailyForecasts.forEach { forecast ->
                    DailyForecastItem(
                        day = forecast.day,
                        temp = forecast.temp,
                        condition = forecast.condition,
                        imageId = forecast.imageId
                    )
                }
            }
        }
    }
}

@Composable
fun WeatherInfoPill(label: String, value: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(Color.White.copy(alpha = 0.1f))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text("$label : $value", color = Color.White, fontSize = 14.sp)
    }
}

@Composable
fun WeatherDetailItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(label, color = Color.Gray, fontSize = 14.sp)
    }
}

@Composable
fun HourlyForecastItem(time: String, temp: String, imageId: Int, isNow: Boolean = false) {
    val backgroundColor = if (isNow) Color.White else Color.White.copy(alpha = 0.1f)
    val contentColor = if (isNow) Color(0xFF0B132B) else Color.White

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .padding(vertical = 12.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(time, color = contentColor, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(temp, color = contentColor, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun DailyForecastItem(day: String, temp: String, condition: String, imageId: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = day,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f)
        )
        Image(
            painter = painterResource(id = imageId),
            contentDescription = condition,
            modifier = Modifier
                .size(32.dp)
                .weight(1f)
        )
        Text(
            text = temp,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = condition,
            color = Color.Gray,
            fontSize = 16.sp,
            modifier = Modifier.weight(1.5f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CuacaScreenPreview() {
    CuacaScreen()
}