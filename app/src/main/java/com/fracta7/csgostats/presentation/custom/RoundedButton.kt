package com.fracta7.csgostats.presentation.custom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fracta7.csgostats.presentation.ui.theme.CSGOStatsTheme


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun RoundedButtonPreview() {
    CSGOStatsTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                RoundedButton(text = "Button", onClick = {})
                Spacer(modifier = Modifier.padding(5.dp))
                OutlinedRoundedButton(text = "Button", onClick = {})
            }
        }
    }

}

@Composable
fun RoundedButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = CircleShape,
        elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp),
        contentPadding = PaddingValues(20.dp, 12.dp)
    ) {
        Text(text = text)
    }
}

@Composable
fun OutlinedRoundedButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = CircleShape,
        elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp),
        contentPadding = PaddingValues(20.dp, 12.dp),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text(text = text)
    }
}