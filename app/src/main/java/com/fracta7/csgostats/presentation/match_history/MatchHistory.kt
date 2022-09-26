package com.fracta7.csgostats.presentation.match_history

import android.annotation.SuppressLint
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.fracta7.csgostats.R
import com.fracta7.csgostats.domain.model.UserStats
import com.fracta7.csgostats.presentation.navigation.Screens
import com.fracta7.csgostats.presentation.ui.theme.*
import kotlinx.coroutines.DelicateCoroutinesApi

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun MatchHistory(
    navController: NavController
) {
    val activity = LocalContext.current as? Activity
    val viewModel = hiltViewModel<MatchHistoryViewModel>()

    Scaffold(content = {
        AnimatedVisibility(!viewModel.state.isDbEmpty) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Card(
                    shape = Shapes.large,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
                ) {
                    LazyColumn {
                        items(viewModel.state.userStats) { userStat ->
                            MatchCard(
                                userStat
                            )
                        }
                    }
                }
                if (viewModel.state.openDialog) {
                    AlertDialog(
                        onDismissRequest = {
                            viewModel.onEvent(MatchHistoryEvent.ToggleDialog)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_error_24),
                                contentDescription = "warning"
                            )
                        },
                        title = { Text(text = "WARNING!") },
                        text = { Text(text = "This action will DELETE ALL MATCHES!") },
                        confirmButton = {
                            TextButton(onClick = {
                                viewModel.onEvent(MatchHistoryEvent.ClearHistory)
                                navController.navigate(Screens.MatchHistory.route)
                            }) {
                                Text(text = "Delete", color = error)
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = {
                                viewModel.onEvent(MatchHistoryEvent.ToggleDialog)
                            }) {
                                Text(text = "Cancel")
                            }
                        }
                    )
                }
            }
        }

        AnimatedVisibility(viewModel.state.isDbEmpty) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(12.dp)) {
                Text(
                    text = "No stats are available. Please add a new match",
                    style = MaterialTheme.typography.bodyLarge,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    },
        floatingActionButton = {
            Button(
                onClick = {
                    viewModel.onEvent(MatchHistoryEvent.ToggleDialog)
                },
                colors = ButtonDefaults.buttonColors(containerColor = errorContainer),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.delete_24px),
                    contentDescription = "delete",
                    tint = onErrorContainer
                )
            }
        })

    BackHandler(onBack = { activity?.finish() })
}


@Composable
fun MatchCard(
    userStats: UserStats
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp, 8.dp),
        shape = Shapes.large
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            var painter: Int = R.drawable.map_icon_lobby_mapveto
            when (userStats.map) {
                0 -> painter = R.drawable.map_icon_de_dust2
                1 -> painter = R.drawable.collection_icon_de_inferno
                2 -> painter = R.drawable.map_icon_de_mirage
                3 -> painter = R.drawable.map_icon_de_nuke
                4 -> painter = R.drawable.map_icon_cs_office
                5 -> painter = R.drawable.map_icon_de_overpass
                6 -> painter = R.drawable.map_icon_de_train
                7 -> painter = R.drawable.map_icon_de_vertigo
                8 -> painter = R.drawable.map_icon_cs_agency
                9 -> painter = R.drawable.map_icon_de_ancient
                10 -> painter = R.drawable.map_icon_de_cache
                11 -> painter = R.drawable.map_icon_de_cbble
                12 -> painter = R.drawable.map_icon_de_lake
                13 -> painter = R.drawable.map_icon_de_safehouse
                14 -> painter = R.drawable.map_icon_de_shortdust
                15 -> painter = R.drawable.map_icon_de_shortnuke
                16 -> painter = R.drawable.map_icon_lobby_mapveto
            }

            Image(
                painter = painterResource(id = painter),
                contentDescription = "map icon",
                modifier = Modifier

                    .requiredSize(78.dp)
            )

            Column {

                Text(text = "${userStats.matchScore}", fontSize = Typography.titleLarge.fontSize)
                Text(
                    text = "${userStats.duration} minutes",
                    fontSize = Typography.labelSmall.fontSize,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "${userStats.date}",
                    fontSize = Typography.labelSmall.fontSize,
                    fontStyle = FontStyle.Italic
                )
            }

            Column {
                Row {
                    Text(text = "Kills:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = userStats.kills.toString())

                }
                Spacer(Modifier.padding(4.dp))
                Row {
                    Text(text = "Deaths:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = userStats.deaths.toString())
                }
                Spacer(Modifier.padding(4.dp))
                Row {
                    Text(text = "Assists:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = userStats.assists.toString())
                }
            }

            Column {
                Row {
                    Text(text = "HS%:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = "${userStats.hs}%")

                }
                Spacer(Modifier.padding(4.dp))
                Row {
                    Text(text = "DPR:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = userStats.dpr.toString())
                }
                Spacer(Modifier.padding(4.dp))
                Row {
                    Text(text = "MVPs:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = userStats.mvps.toString())
                }
            }
        }
    }
}