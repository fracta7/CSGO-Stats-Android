package com.fracta7.csgostats.presentation.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fracta7.csgostats.presentation.ui.theme.CSGOStatsTheme
import com.fracta7.csgostats.presentation.ui.theme.Typography

@Composable
fun GeneralStats(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "General Stats",
            modifier = Modifier.padding(48.dp),
            fontSize = Typography.headlineLarge.fontSize
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewGeneral() {
    CSGOStatsTheme(darkTheme = true) {
        Surface() {
            GeneralStats(navController = NavController(LocalContext.current))
        }
    }
}