package com.fracta7.csgostats.presentation.user_stats

import android.annotation.SuppressLint
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.fracta7.csgostats.R
import com.fracta7.csgostats.presentation.custom.BriefStats
import com.fracta7.csgostats.presentation.custom.ProgressBarItem
import com.fracta7.csgostats.presentation.custom.RegularItem
import com.fracta7.csgostats.presentation.navigation.Screens
import com.fracta7.csgostats.presentation.ui.theme.Shapes
import kotlinx.coroutines.DelicateCoroutinesApi

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserStats(
    navController: NavController
) {
    val activity = LocalContext.current as? Activity
    val viewModel = hiltViewModel<UserStatsViewModel>()
    val state = viewModel.state
    val textsWithPercent by
    mutableStateOf(
        listOf(
            "Average HS%: ${state.hs}%" to state.hspercent,
            "Highest HS%: ${state.highestHS}%" to state.highestHS,
            "Total games as CT start: ${state.startedAsCt}" to state.ctchance,
            "Average DPR: ${state.dpr}" to state.dprchance,
            "Max DPR: ${state.maxDPR}" to state.maxdprchance,
            "Total KD: ${state.totalKD}" to state.totalkdchance,
            "Average KD per game: ${state.averageKD}" to state.averagekdchance,
            "Average MVPs per game: ${state.averageMVPs}" to state.mvppercent,
            "Average kills per game: ${state.averageKills}" to state.killpercent,
            "Average assists per game: ${state.averageAssists}" to state.assistpercent,
            "Average deaths per game: ${state.averageDeaths}" to state.deathpercent,
            "Average duration of the game per game: ${state.averageDuration}" to state.durationpercent
        )
    )

    val texts by
    mutableStateOf(
        listOf(
            "Total MVPs: ${state.mvps}",
            "Total Duration: ${state.duration} minutes",
            "Highest kill count: ${state.maxKills}",
            "Highest assist count: ${state.maxAssists}",
            "Highest death count: ${state.maxDeath}",
            "Highest MVP count: ${state.maxMVPs}",
            "Highest DPR value: ${state.maxDPR}",
            "Longest game duration: ${state.maxDuration} minutes",

            )
    )

    val briefStatItems by
    mutableStateOf(
        listOf(
            "${state.kills} kills" to R.drawable.ic_hs,
            "${state.assists} assists" to R.drawable.ic_assist,
            "${state.deaths} deaths" to R.drawable.ic_death
        )
    )

    BackHandler(onBack = { activity?.finish() })

    Scaffold(
        content = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    shape = Shapes.large,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                ) {
                    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                        item {
                            Card(shape = Shapes.large) {
                                LazyRow(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    items(briefStatItems.size) {
                                        BriefStats(
                                            text = briefStatItems[it].first,
                                            painter = painterResource(id = briefStatItems[it].second)
                                        )
                                    }
                                }
                            }
                        }
                        item {
                            Spacer(modifier = Modifier.padding(4.dp))
                        }
                        items(textsWithPercent.size) {
                            ProgressBarItem(
                                text = textsWithPercent[it].first,
                                percent = textsWithPercent[it].second
                            )
                            Spacer(modifier = Modifier.padding(4.dp))
                        }
                        items(texts.size) {
                            RegularItem(text = texts[it])
                            Spacer(modifier = Modifier.padding(4.dp))
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            Button(onClick = {
                navController.navigate(Screens.AddStat.route)
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_add_24),
                    contentDescription = "Icon add"
                )
            }
        }
    )
}

