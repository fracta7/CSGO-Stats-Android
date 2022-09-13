package com.fracta7.csgostats.presentation.custom

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.fracta7.csgostats.presentation.ui.theme.Shapes

@Composable
fun RegularItem(text: String) {
    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier.padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = text)

            }
        }
    }
}

@Composable
fun ProgressBarItem(text: String, percent: Float) {
    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier.padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = text)

            }
            CustomProgressBar(percentage = percent)
        }
    }
}

@Composable
fun BriefStats(text: String, painter: Painter) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painter,
            contentDescription = "stat icon",
            modifier = Modifier.requiredSize(32.dp)
        )
        Text(text = text)
    }
}