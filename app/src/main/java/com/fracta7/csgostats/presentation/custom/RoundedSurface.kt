package com.fracta7.csgostats.presentation.custom

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fracta7.csgostats.presentation.ui.theme.onCardBg

@Composable
fun RoundedSurface(text: String) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Text(text = text, color = onCardBg, modifier = Modifier.padding(20.dp))
        }
    }
}

@Preview
@Composable
fun preview() {
    Surface{
        RoundedSurface(text = "Text")
    }
}