package com.fracta7.csgostats.presentation.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fracta7.csgostats.presentation.ui.theme.Typography

@Composable
fun MapStats() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Map Stats",
            modifier = Modifier.padding(48.dp),
            fontSize = Typography.headlineLarge.fontSize
        )
    }
}