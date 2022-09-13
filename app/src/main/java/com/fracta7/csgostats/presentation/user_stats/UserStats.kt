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
import androidx.compose.runtime.remember
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
import com.fracta7.csgostats.presentation.ui.theme.CSGOStatsTheme
import com.fracta7.csgostats.presentation.ui.theme.Shapes
import kotlinx.coroutines.DelicateCoroutinesApi

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun UserStats(
    navController: NavController
) {
    val activity = LocalContext.current as? Activity
    val viewmodel = hiltViewModel<UserStatsViewModel>()
    val stats by remember { mutableStateOf(viewmodel.state) }
    val textsWithPercent by remember {
        mutableStateOf(
            listOf(
                "Average HS%: ${stats.hs}%" to stats.hspercent,
                "Highest HS%: ${stats.highestHS}%" to stats.highestHS,
                "Total games as CT start: ${stats.startedAsCt}" to stats.ctchance,
                "Average DPR: ${stats.dpr}" to stats.dprchance,
                "Max DPR: ${stats.maxDPR}" to stats.maxdprchance,
                "Total KD: ${stats.totalKD}" to stats.totalkdchance,
                "Average KD per game: ${stats.averageKD}" to stats.averagekdchance,
                "Average MVPs per game: ${stats.averageMVPs}" to stats.mvppercent,
                "Average kills per game: ${stats.averageKills}" to stats.killpercent,
                "Average assists per game: ${stats.averageAssists}" to stats.assistpercent,
                "Average deaths per game: ${stats.averageDeaths}" to stats.deathpercent,
                "Average duration of the game per game: ${stats.averageDuration}" to stats.durationpercent
            )
        )
    }
    val texts by remember {
        mutableStateOf(
            listOf(
                "Total MVPs: ${stats.mvps}",
                "Total Duration: ${stats.duration} minutes",
                "Highest kill count: ${stats.maxKills}",
                "Highest assist count: ${stats.maxAssists}",
                "Highest death count: ${stats.maxDeath}",
                "Highest MVP count: ${stats.maxMVPs}",
                "Highest DPR value: ${stats.maxDPR}",
                "Longest game duration: ${stats.maxDuration} minutes",

                )
        )
    }
    val briefStatItems by remember {
        mutableStateOf(
            listOf(
                "${stats.kills} kills" to R.drawable.ic_hs,
                "${stats.assists} assists" to R.drawable.ic_assist,
                "${stats.deaths} deaths" to R.drawable.ic_death
            )
        )
    }

    CSGOStatsTheme(darkTheme = true) {
        Surface {
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
    }
}

