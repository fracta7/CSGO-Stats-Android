package com.fracta7.csgostats.presentation.custom

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fracta7.csgostats.presentation.ui.theme.*

@Composable
fun CustomProgressBar(percentage: Float, bg: Color, primary: Color) {
    Canvas(
        modifier = Modifier
            .padding(12.dp)
            .size(500.dp, 32.dp)
            .fillMaxWidth()
    ) {
        this.drawRoundRect(
            brush = Brush.horizontalGradient(colors = listOf(bg, bg)),
            size = Size(600f, 32f),
            cornerRadius = CornerRadius(20f, 20f)
        )
        this.drawRoundRect(
            brush = Brush.horizontalGradient(colors = listOf(primary, primary)),
            size = Size(percentage * 6f, 32f),
            cornerRadius = CornerRadius(20f, 20f)
        )
    }
}