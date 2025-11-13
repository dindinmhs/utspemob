package com.example.utspemob.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BlurredGradientCircle(
    modifier: Modifier = Modifier,
    size: Dp = 600.dp,
    offsetX: Dp = 150.dp,
    offsetY: Dp = (-320).dp,
    blurRadius: Dp = 200.dp,
    colors: List<Color> = listOf(
        Color(0xFFB388FF).copy(alpha = 0.7f),
        Color(0xFF7C4DFF).copy(alpha = 0.0f)
    )
) {
    Box(
        modifier = modifier
            .size(size)
            .offset(x = offsetX, y = offsetY)
            .background(
                brush = Brush.radialGradient(colors = colors),
                shape = CircleShape
            )
            .blur(blurRadius)
    )
}

@Composable
fun BlurredGradientBackground(
    modifier: Modifier = Modifier,
    height: Dp = 350.dp,
    blurRadius: Dp = 150.dp,
    colors: List<Color> = listOf(
        Color(0xFF7C4DFF).copy(alpha = 0.8f),
        Color(0xFFB388FF).copy(alpha = 0.3f),
        Color.Transparent
    )
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .background(brush = Brush.verticalGradient(colors))
            .blur(blurRadius)
    )
}
