package com.fracta7.csgostats.presentation.add_stats

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.fracta7.csgostats.R
import com.fracta7.csgostats.presentation.navigation.Screens
import com.fracta7.csgostats.presentation.ui.theme.Shapes
import kotlinx.coroutines.DelicateCoroutinesApi


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun AddStatScreen(navController: NavController) {
    LocalContext.current
    val viewModel = hiltViewModel<AddStatsViewModel>()

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = Shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
                .padding(12.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
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
                        onValueChange = {
                            var input = it
                            if (input=="") input ="0"
                            if(input.toInt()>=999) input = "999" else if(input.toInt()<=0) input = "0"
                            viewModel.state = viewModel.state.copy(kills = input)
                            viewModel.state = viewModel.state.copy(isKillEmpty = false)
                        },
                        modifier = modifier,
                        label = { Text(text = "Kills") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_hs),
                                contentDescription = null,
                                modifier = Modifier.requiredSize(24.dp)
                            )
                        },
                        isError = viewModel.state.isKillEmpty,
                        singleLine = true
                    )
                }
                item {
                    OutlinedTextField(
                        value = viewModel.state.assists,
                        onValueChange = {
                            var input = it
                            if (input=="") input ="0"
                            if(input.toInt()>=999) input = "999" else if(input.toInt()<=0) input = "0"
                            viewModel.state = viewModel.state.copy(assists = input)
                            viewModel.state = viewModel.state.copy(isAssistEmpty = false)
                        },
                        modifier = modifier,
                        label = { Text(text = "Assists") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        shape = Shapes.large,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_assist),
                                contentDescription = null,
                                modifier = Modifier.requiredSize(24.dp)
                            )
                        },
                        isError = viewModel.state.isAssistEmpty,
                        singleLine = true
                    )
                }

                item {
                    OutlinedTextField(
                        value = viewModel.state.deaths,
                        onValueChange = {
                            var input = it
                            if (input=="") input ="0"
                            if(input.toInt()>=999) input = "999" else if(input.toInt()<=0) input = "0"
                            viewModel.state = viewModel.state.copy(deaths = input)
                            viewModel.state = viewModel.state.copy(isDeathEmpty = false)
                        },
                        modifier = modifier,
                        label = { Text(text = "Deaths") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_death),
                                contentDescription = null,
                                modifier = Modifier.requiredSize(24.dp)
                            )
                        },
                        isError = viewModel.state.isDeathEmpty,
                        singleLine = true
                    )
                }

                item {
                    OutlinedTextField(
                        value = viewModel.state.hs,
                        onValueChange = {
                            var input = it
                            if (input=="") input ="0"
                            if(input.toInt()>=100) input = "100" else if(input.toInt()<=0) input = "0"
                            viewModel.state = viewModel.state.copy(hs = input)
                            viewModel.state = viewModel.state.copy(isHSEmpty = false)
                        },
                        modifier = modifier,
                        label = { Text(text = "HS%") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.percent),
                                contentDescription = null,
                                modifier = Modifier.requiredSize(24.dp)
                            )
                        },
                        isError = viewModel.state.isHSEmpty,
                        singleLine = true
                    )
                }

                item {
                    OutlinedTextField(
                        value = viewModel.state.dpr,
                        onValueChange = {
                            var input = it
                            if (input=="") input ="0"
                            if(input.toFloat()>=500) input = "500" else if(input.toFloat()<=0) input = "0"
                            viewModel.state = viewModel.state.copy(dpr = input)
                            viewModel.state = viewModel.state.copy(isDPREmpty = false)
                        },
                        modifier = modifier,
                        label = { Text(text = "DPR") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.chart_24px),
                                contentDescription = null
                            )
                        },
                        isError = viewModel.state.isDPREmpty,
                        singleLine = true
                    )
                }

                item {
                    OutlinedTextField(
                        value = viewModel.state.mvps,
                        onValueChange = {
                            var input = it
                            if (input=="") input ="0"
                            if(input.toInt()>=99) input = "99" else if(input.toInt()<=0) input = "0"
                            viewModel.state = viewModel.state.copy(mvps = input)
                            viewModel.state = viewModel.state.copy(isMVPEmpty = false)
                        },
                        modifier = modifier,
                        label = { Text(text = "MVPs") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.mvp),
                                contentDescription = null
                            )
                        },
                        isError = viewModel.state.isMVPEmpty,
                        singleLine = true
                    )
                }

                item {
                    Row(
                        modifier = modifier,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = viewModel.state.score1,
                            onValueChange = {
                                var input = it
                                if (input=="") input ="0"
                                if(input.toInt()>=99) input = "99" else if(input.toInt()<=0) input = "0"
                                viewModel.state = viewModel.state.copy(score1 = input)
                                viewModel.state = viewModel.state.copy(isScore1Empty = false)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.45f),
                            label = { Text(text = "You") },
                            shape = Shapes.large,
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.score),
                                    contentDescription = null
                                )
                            },
                            isError = viewModel.state.isScore1Empty,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true
                        )
                        Text(
                            text = ":",
                            modifier = Modifier
                                .weight(0.1f)
                                .padding(4.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        OutlinedTextField(
                            value = viewModel.state.score2,
                            onValueChange = {
                                var input = it
                                if (input=="") input ="0"
                                if(input.toInt()>=99) input = "99" else if(input.toInt()<=0) input = "0"
                                viewModel.state = viewModel.state.copy(score2 = input)
                                viewModel.state = viewModel.state.copy(isScore2Empty = false)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.45f),
                            label = { Text(text = "Enemy") },
                            shape = Shapes.large,
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.score),
                                    contentDescription = null
                                )
                            },
                            isError = viewModel.state.isScore2Empty,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true
                        )
                    }

                }

                item {

                    OutlinedTextField(
                        value = viewModel.state.duration,
                        onValueChange = {
                            var duration = it
                            if (duration=="") duration ="0"
                            if(duration.toInt()>=999) duration = "999" else if(duration.toInt()<=0) duration = "1"
                            viewModel.state = viewModel.state.copy(duration = duration)
                            viewModel.state = viewModel.state.copy(isDurationEmpty = false)
                        },
                        modifier = modifier,
                        label = { Text(text = "Duration") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.duration),
                                contentDescription = null
                            )
                        },
                        isError = viewModel.state.isDurationEmpty,
                        singleLine = true
                    )
                }

                item {
                    Row(
                        modifier = modifier,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = viewModel.state.day,
                            onValueChange = {
                                var day = it
                                if (day=="") day ="0"
                                if(day.toInt()>=31) day = "31" else if(day.toInt()<=0) day = "1"
                                viewModel.state = viewModel.state.copy(day = day)
                                viewModel.state = viewModel.state.copy(isDayEmpty = false)
                            },
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxWidth(),
                            label = { Text(text = "Day") },
                            shape = Shapes.large,
                            isError = viewModel.state.isDayEmpty,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true
                        )
                        Spacer(modifier = Modifier.padding(horizontal = 4.dp).weight(0.03f))
                        OutlinedTextField(
                            value = viewModel.state.month,
                            onValueChange = {
                                var month = it
                                if (month=="") month ="0"
                                if(month.toInt()>=12) month = "12" else if(month.toInt()<=0) month = "1"
                                viewModel.state = viewModel.state.copy(month = month)
                                viewModel.state = viewModel.state.copy(isMonthEmpty = false)
                            },
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxWidth(),
                            label = { Text(text = "Month") },
                            shape = Shapes.large,
                            isError = viewModel.state.isMonthEmpty,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true
                        )
                        Spacer(modifier = Modifier.padding(horizontal = 4.dp).weight(0.03f))
                        OutlinedTextField(
                            value = viewModel.state.year,
                            onValueChange = {
                                var year = it
                                if (year=="") year ="0"
                                if(year.toInt()>=9999) year = "9999" else if(year.toInt()<=0) year = "1"
                                viewModel.state = viewModel.state.copy(year = year)
                                viewModel.state = viewModel.state.copy(isYearEmpty = false)
                            },
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxWidth(),
                            label = { Text(text = "Year") },
                            shape = Shapes.large,
                            isError = viewModel.state.isYearEmpty,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true
                        )
                    }

                }
                item {
                    var expanded by remember { mutableStateOf(false) }
                    var text by remember { mutableStateOf("Dust2") }

                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        TextButton(onClick = { expanded = !expanded }) {
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
                        /*
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
                        } */
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
                if(viewModel.state.noError){
                    navController.navigate(Screens.UserStats.route)
                }
            }) {
                Text(text = "Add")
            }
        }
    }
}
