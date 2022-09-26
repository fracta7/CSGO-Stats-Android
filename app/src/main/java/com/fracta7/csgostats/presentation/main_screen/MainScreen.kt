package com.fracta7.csgostats.presentation.main_screen


import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fracta7.csgostats.presentation.custom.Chart
import com.fracta7.csgostats.presentation.ui.theme.CSGOStatsTheme

@Composable
fun MainScreen() {
    val activity = LocalContext.current as? Activity
    val viewModel = hiltViewModel<MainScreenViewModel>()
    val state = viewModel.state
    val kills by mutableStateOf(state.stats.map { it.kills?.toFloat() })
    val deaths by mutableStateOf(state.stats.map { it.deaths?.toFloat() })
    val assists by mutableStateOf(state.stats.map { it.assists?.toFloat() })
    val hs by mutableStateOf(state.stats.map { it.hs })
    val dpr by mutableStateOf(state.stats.map { it.dpr })
    val mvps by mutableStateOf(state.stats.map { it.mvps?.toFloat() })
    val duration by mutableStateOf(state.stats.map { it.duration?.toFloat() })
    val padding = 50.dp


    CSGOStatsTheme {
        BackHandler(onBack = { activity?.finish() })
        AnimatedVisibility(viewModel.state.showStats) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                    item {
                        Card(
                            shape = ShapeDefaults.ExtraLarge,
                            modifier = Modifier
                                .padding(vertical = 12.dp)
                                .fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = "Kills",
                                    style = MaterialTheme.typography.titleLarge,
                                    modifier = Modifier.padding(horizontal = 24.dp)
                                )
                                Spacer(modifier = Modifier.padding(padding))
                                Chart(
                                    info = kills as List<Float>,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(250.dp)
                                )
                            }
                        }
                    }
                    item {
                        Card(
                            shape = ShapeDefaults.ExtraLarge,
                            modifier = Modifier
                                .padding(vertical = 12.dp)
                                .fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = "Assists",
                                    style = MaterialTheme.typography.titleLarge,
                                    modifier = Modifier.padding(horizontal = 24.dp)
                                )
                                Spacer(modifier = Modifier.padding(padding))
                                Chart(
                                    info = assists as List<Float>,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(250.dp)
                                )
                            }
                        }
                    }
                    item {
                        Card(
                            shape = ShapeDefaults.ExtraLarge,
                            modifier = Modifier
                                .padding(vertical = 12.dp)
                                .fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = "Deaths",
                                    style = MaterialTheme.typography.titleLarge,
                                    modifier = Modifier.padding(horizontal = 24.dp)
                                )
                                Spacer(modifier = Modifier.padding(padding))
                                Chart(
                                    info = deaths as List<Float>,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(250.dp)
                                )
                            }
                        }
                    }
                    item {
                        Card(
                            shape = ShapeDefaults.ExtraLarge,
                            modifier = Modifier
                                .padding(vertical = 12.dp)
                                .fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = "HS%",
                                    style = MaterialTheme.typography.titleLarge,
                                    modifier = Modifier.padding(horizontal = 24.dp)
                                )
                                Spacer(modifier = Modifier.padding(padding))
                                Chart(
                                    info = hs as List<Float>,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(250.dp)
                                )
                            }
                        }
                    }
                    item {
                        Card(
                            shape = ShapeDefaults.ExtraLarge,
                            modifier = Modifier
                                .padding(vertical = 12.dp)
                                .fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = "DPR",
                                    style = MaterialTheme.typography.titleLarge,
                                    modifier = Modifier.padding(horizontal = 24.dp)
                                )
                                Spacer(modifier = Modifier.padding(padding))
                                Chart(
                                    info = dpr as List<Float>,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(250.dp)
                                )
                            }
                        }
                    }
                    item {
                        Card(
                            shape = ShapeDefaults.ExtraLarge,
                            modifier = Modifier
                                .padding(vertical = 12.dp)
                                .fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = "MVPs",
                                    style = MaterialTheme.typography.titleLarge,
                                    modifier = Modifier.padding(horizontal = 24.dp)
                                )
                                Spacer(modifier = Modifier.padding(padding))
                                Chart(
                                    info = mvps as List<Float>,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(250.dp)
                                )
                            }
                        }
                    }
                    item {
                        Card(
                            shape = ShapeDefaults.ExtraLarge,
                            modifier = Modifier
                                .padding(vertical = 12.dp)
                                .fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = "Duration",
                                    style = MaterialTheme.typography.titleLarge,
                                    modifier = Modifier.padding(horizontal = 24.dp)
                                )
                                Spacer(modifier = Modifier.padding(padding))
                                Chart(
                                    info = duration as List<Float>,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(250.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        AnimatedVisibility(!viewModel.state.showStats) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(12.dp)) {
                Text(
                    text = "No stats are available. Please add a new match",
                    style = MaterialTheme.typography.bodyLarge,
                    fontStyle = FontStyle.Italic
                )
            }
        }

    }
}