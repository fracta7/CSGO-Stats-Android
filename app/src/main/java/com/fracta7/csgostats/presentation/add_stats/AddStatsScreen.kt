package com.fracta7.csgostats.presentation.add_stats

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.fracta7.csgostats.presentation.ui.theme.Shapes
import com.fracta7.csgostats.presentation.ui.theme.surfaceVariant
import kotlinx.coroutines.DelicateCoroutinesApi


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun AddStatScreen(navController: NavController) {
    LocalContext.current
    val viewModel = hiltViewModel<AddStatsViewModel>()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = Shapes.large,
            modifier = Modifier
                .size(500.dp, 500.dp)
                .padding(12.dp),
            colors = CardDefaults.cardColors(containerColor = surfaceVariant)
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                val modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp)
                item {
                    OutlinedTextField(
                        value = viewModel.state.kills,
                        onValueChange = { viewModel.state = viewModel.state.copy(kills = it) },
                        modifier = modifier,
                        label = { Text(text = "Kills") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large
                    )
                }
                item {
                    OutlinedTextField(
                        value = viewModel.state.assists,
                        onValueChange = { viewModel.state = viewModel.state.copy(assists = it) },
                        modifier = modifier,
                        label = { Text(text = "Assists") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        shape = Shapes.large
                    )
                }

                item {
                    OutlinedTextField(
                        value = viewModel.state.deaths,
                        onValueChange = { viewModel.state = viewModel.state.copy(deaths = it) },
                        modifier = modifier,
                        label = { Text(text = "Deaths") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large
                    )
                }

                item {
                    OutlinedTextField(
                        value = viewModel.state.hs,
                        onValueChange = { viewModel.state = viewModel.state.copy(hs = it) },
                        modifier = modifier,
                        label = { Text(text = "HS%") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large
                    )
                }

                item {
                    OutlinedTextField(
                        value = viewModel.state.dpr,
                        onValueChange = { viewModel.state = viewModel.state.copy(dpr = it) },
                        modifier = modifier,
                        label = { Text(text = "DPR") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large
                    )
                }

                item {
                    OutlinedTextField(
                        value = viewModel.state.mvps,
                        onValueChange = { viewModel.state = viewModel.state.copy(mvps = it) },
                        modifier = modifier,
                        label = { Text(text = "MVPs") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large
                    )
                }

                item {

                    OutlinedTextField(
                        value = viewModel.state.matchscore,
                        onValueChange = { viewModel.state = viewModel.state.copy(matchscore = it) },
                        modifier = modifier,
                        label = { Text(text = "Match Score") },
                        shape = Shapes.large
                    )
                }

                item {

                    OutlinedTextField(
                        value = viewModel.state.duration,
                        onValueChange = { viewModel.state = viewModel.state.copy(duration = it) },
                        modifier = modifier,
                        label = { Text(text = "Duraiton") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large
                    )
                }

                item {

                    OutlinedTextField(
                        value = viewModel.state.date,
                        onValueChange = { viewModel.state = viewModel.state.copy(date = it) },
                        modifier = modifier,
                        label = { Text(text = "Date") },
                        shape = Shapes.large
                    )
                }
                item {
                    var expanded by remember { mutableStateOf(false) }
                    var text by remember { mutableStateOf("Dust2") }

                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Row(
                            modifier = Modifier
                                .padding(24.dp)
                                .clickable {
                                    expanded = !expanded
                                },
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = text,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Icon(
                                imageVector = Icons.Filled.ArrowDropDown,
                                contentDescription = "dropdown arrow"
                            )
                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }) {
                                viewModel.state.maps.forEach { item ->
                                    DropdownMenuItem(onClick = {
                                        expanded = false
                                        text = item
                                        viewModel.state = viewModel.state.copy(selectedMap = text)
                                    }, text = { Text(text = item) })
                                }
                            }
                        }
                    }
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Started as CT?", Modifier.padding(end = 8.dp))
                        Checkbox(
                            checked = viewModel.state.startedAsCT,
                            onCheckedChange = {
                                viewModel.state = viewModel.state.copy(startedAsCT = it)
                            })
                    }
                }
            }
        }

        Row() {
            ElevatedButton(onClick = {
                navController.popBackStack()
            }) {
                Text(text = "Cancel")
            }
            Spacer(modifier = Modifier.padding(12.dp))
            Button(onClick = {
                viewModel.onEvent(AddStatsEvent.AddStat)
                navController.popBackStack()
            }) {
                Text(text = "Add")
            }
        }
    }
}
