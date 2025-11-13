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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CuacaScreen() {
    val lokasi = "Berlin, Germany"
    val tanggal = "Monday, June 23"
    val suhuUtama = "24°"
    val kondisiUtama = "Partly Cloudy"
    val highTemp = "26°C"
    val lowTemp = "18°C"
    val humidity = "62%"
    val wind = "19 km/h"
    val rain = "24%"

    val hourlyForecasts = listOf(
        HourlyData("11:00", "20°"),
        HourlyData("Now", "20°"),
        HourlyData("13:00", "21°"),
        HourlyData("14:00", "20°"),
        HourlyData("15:00", "20°"),
        HourlyData("16:00", "19°")
    )

    val dailyForecasts = listOf(
        DailyData("Mon", "26°C", "Partly Cloudy"),
        DailyData("Tue", "24°C", "Showers"),
        DailyData("Wed", "25°C", "Sunny"),
        DailyData("Thu", "23°C", "Thunderstorm"),
        DailyData("Fri", "22°C", "Rainy")
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // 🌈 Gradasi hanya di atas
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF7C4DFF),
                            Color(0xFFB388FF),
                            Color(0xFFB388FF).copy(alpha = 0f)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(lokasi, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Medium)
            Text(tanggal, color = Color.White.copy(alpha = 0.7f), fontSize = 14.sp)

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                // 🌥️ Ikon awan dengan gradasi ungu
                Box(
                    modifier = Modifier
                        .size(140.dp)
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF7C4DFF), Color(0xFFB388FF)),
                                start = Offset(0f, 0f),
                                end = Offset(140f, 140f)
                            ),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Cloud,
                        contentDescription = "Cloud Icon",
                        modifier = Modifier.size(80.dp),
                        tint = Color.White
                    )
                }

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
                        isNow = forecast.time == "Now"
                    )
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            // 🌫️ Efek kaca ungu muda transparan
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xFFB388FF).copy(alpha = 0.25f),
                        shape = RoundedCornerShape(24.dp)
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
                            condition = forecast.condition
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HourlyForecastItem(time: String, temp: String, isNow: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(
                color = if (isNow) Color(0xFFB388FF).copy(alpha = 0.3f) else Color.Transparent,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(12.dp)
    ) {
        Text(time, color = Color.Black, fontWeight = if (isNow) FontWeight.Bold else FontWeight.Normal)
        Icon(
            imageVector = Icons.Default.Cloud,
            contentDescription = "Cloud",
            tint = Color.LightGray,
            modifier = Modifier.size(32.dp)
        )
        Text(temp, color = Color.Black)
    }
}

@Composable
fun DailyForecastItem(day: String, temp: String, condition: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(day, color = Color.Black)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Cloud,
                contentDescription = condition,
                tint = Color(0xFF7C4DFF),
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(temp, color = Color.Black)
        }
    }
}

data class HourlyData(val time: String, val temp: String)
data class DailyData(val day: String, val temp: String, val condition: String)


@Composable
fun WeatherInfoPill(label: String, value: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(Color.White.copy(alpha = 0.1f))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text("$label : $value", color = Color.Black, fontSize = 14.sp)
    }
}

@Composable
fun WeatherDetailItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(label, color = Color.Gray, fontSize = 14.sp)
    }
}

@Composable
fun HourlyForecastItem(time: String, temp: String, imageId: Int, isNow: Boolean = false) {
    val backgroundColor = if (isNow) Color.White else Color.White.copy(alpha = 0.1f)
    val contentColor = if (isNow) Color(0xFF0B132B) else Color.Black

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