package com.fracta7.csgostats.presentation.custom

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fracta7.csgostats.presentation.ui.theme.CSGOStatsTheme
import kotlin.math.round
import kotlin.math.roundToInt

val sampleValues = listOf(
    45f,
    23f,
    56f,
    88f,
    77f,
    35f
)

@Composable
fun Chart(
    info: List<Float>,
    modifier: Modifier = Modifier,
    graphColor: Color = MaterialTheme.colorScheme.primary
) {
    val spacing = 100f
    val transparentGraphColor = remember {
        graphColor.copy(alpha = 0.5f)
    }
    val upperValue = remember(info) {
        (info.maxOfOrNull { it }?.plus(1)?.roundToInt() ?: 0)
    }
    val lowerValue = remember(info) {
        (info.minOfOrNull { it }?.toInt() ?: 0)
    }

    val density = LocalDensity.current

    val textPaint = remember {
        Paint().apply {
            color = android.graphics.Color.WHITE
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }

    Canvas(modifier = modifier) {
        val spacePerInfo = (size.width - spacing) / info.size
        (0 until info.size - 1 step 2).forEach {
            val infoEntry = info[it]
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    it.toString(),
                    spacing + it * spacePerInfo,
                    size.height - 5,
                    textPaint
                )
            }
        }
        val infoStep = (upperValue - lowerValue) / 5f
        (0..5).forEach {
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    round(lowerValue + infoStep * it).toString(),
                    30f,
                    size.height - spacing - it * size.height / 5f,
                    textPaint
                )
            }
        }
        var lastX = 0f
        val strokePath = Path().apply {
            val height = size.height
            for (i in info.indices) {
                val currentInfo = info[i]
                val nextInfo = info.getOrNull(i + 1) ?: info.last()
                val leftRatio = (currentInfo - lowerValue) / (upperValue - lowerValue)
                val rightRatio = (nextInfo - lowerValue) / (upperValue - lowerValue)

                val x1 = spacing + i * spacePerInfo
                val y1 = height - spacing - (leftRatio * height).toFloat()
                val x2 = spacing + (i + 1) * spacePerInfo
                val y2 = height - spacing - (rightRatio * height).toFloat()

                if (i == 0) {
                    moveTo(
                        x1,
                        y1
                    )
                }
                lastX = (x1 + x2) / 2f
                quadraticBezierTo(
                    x1, y1, lastX, (y1 + y2) / 2f
                )
            }
        }
        val fillPath = android.graphics.Path(strokePath.asAndroidPath())
            .asComposePath()
            .apply {
                lineTo(lastX, size.height - spacing)
                lineTo(spacing, size.height - spacing)
                close()
            }
        drawPath(
            path = fillPath,
            brush = Brush.verticalGradient(
                colors = listOf(
                    transparentGraphColor,
                    Color.Transparent
                ),
                endY = size.height - spacing
            )
        )
        drawPath(
            path = strokePath,
            color = graphColor,
            style = Stroke(
                width = 3.dp.toPx(),
                cap = StrokeCap.Round
            )
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ChartPrev() {
    CSGOStatsTheme(darkTheme = true) {
        Surface {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(64.dp)
            ) {
                Text(text = "DPR stats for each game", modifier = Modifier.padding(24.dp))

                Spacer(modifier = Modifier.height(50.dp))
                Chart(
                    info = sampleValues,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .align(CenterHorizontally)
                )
            }
        }
    }
}