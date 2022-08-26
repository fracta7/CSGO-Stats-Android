package com.fracta7.csgostats.presentation.user_stats

import android.annotation.SuppressLint
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.room.Room
import com.fracta7.csgostats.R
import com.fracta7.csgostats.data.local.AppDatabase
import com.fracta7.csgostats.data.local.UserStatsEntity
import com.fracta7.csgostats.presentation.custom.CustomProgressBar
import com.fracta7.csgostats.presentation.navigation.Screens
import com.fracta7.csgostats.presentation.ui.theme.CSGOStatsTheme
import com.fracta7.csgostats.presentation.ui.theme.Shapes
import com.fracta7.csgostats.presentation.ui.theme.Typography
import com.fracta7.csgostats.presentation.ui.theme.surface
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserStats(
    navController: NavController
) {
    val activity = LocalContext.current as? Activity
    val db = Room.databaseBuilder(
        LocalContext.current,
        AppDatabase::class.java, "app-database"
    ).allowMainThreadQueries().build()
    val userStats: List<UserStatsEntity> = db.userStatsDao().getAll()

    val totalMatches = userStats.size
    var kills = 0
    var assists = 0
    var deaths = 0
    var hs = 0f
    var dpr = 0f
    var mvps = 0
    var startedAsCT = 0
    var duration = 0
    var totalKD = 0f
    var averageKD = 0f
    var averageKills = 0f
    var averageDeaths = 0f
    var averageAssists = 0f
    var averageMVPs = 0f
    var averageDuration = 0f
    var maxKills = 0
    var maxDeath = 0
    var maxAssists = 0
    var highestHS = 0f
    var maxMVPs = 0
    var maxDPR = 0f
    var maxDuration = 0
    if (userStats.isNotEmpty()) {
        hs = userStats[0].hs!!
        dpr = userStats[0].hs!!
        averageKD = userStats[0].kills!!.toFloat() / userStats[0].deaths!!.toFloat()
        averageKills = userStats[0].kills!!.toFloat()
        averageAssists = userStats[0].assists!!.toFloat()
        averageDeaths = userStats[0].deaths!!.toFloat()
        averageMVPs = userStats[0].mvps!!.toFloat()
        averageDuration = userStats[0].duration!!.toFloat()
    }


    userStats.forEach {
        kills += it.kills!!
        assists += it.assists!!
        deaths += it.deaths!!
        hs = (hs + it.hs!!) / 2
        dpr = (dpr + it.dpr!!) / 2
        mvps += it.mvps!!
        duration += it.duration!!
        if (it.startedAsCT == true) startedAsCT++
        averageKD = (averageKD + (it.kills.toFloat() / deaths.toFloat())) / 2
        averageKills = (averageKills + it.kills.toFloat()) / 2
        averageAssists = (averageAssists + it.assists.toFloat()) / 2
        averageDeaths = (averageDeaths + it.deaths.toFloat()) / 2
        averageMVPs = (averageMVPs + it.mvps.toFloat()) / 2
        averageDuration = (averageDuration + it.duration.toFloat()) / 2
        if (it.kills > maxKills) maxKills = it.kills
        if (it.deaths > maxDeath) maxDeath = it.deaths
        if (it.assists > maxAssists) maxAssists = it.deaths
        if (it.mvps > maxMVPs) maxMVPs = it.mvps
        if (it.hs > highestHS) highestHS = it.hs
        if (it.dpr > maxDPR) maxDPR = it.dpr
        if (it.duration > maxDuration) maxDuration = it.duration
    }
    if (userStats.isNotEmpty()) totalKD = kills.toFloat() / deaths.toFloat()

    var ctchance = 0f
    var hspercent = 0f
    var mvppercent = 0f
    var killpercent = 0f
    var assistpercent = 0f
    var deathpercent = 0f
    var durationpercent = 0f
    var totalkdchance = 0f
    var averagekdchance = 0f
    var dprchance = 0f
    var maxdprchance = 0f
    if (totalMatches != 0) ctchance = (startedAsCT.toFloat() / totalMatches.toFloat()) * 100f
    if (totalMatches != 0) hspercent = (hs / highestHS) * 100f
    if (totalMatches != 0) mvppercent = (averageMVPs / mvps.toFloat()) * 100f
    if (totalMatches != 0) killpercent = (averageKills / kills.toFloat()) * 100f
    if (totalMatches != 0) assistpercent = (averageAssists / assists.toFloat()) * 100f
    if (totalMatches != 0) deathpercent = (averageDeaths / deaths.toFloat()) * 100f
    if (totalMatches != 0) durationpercent = (averageDuration / duration.toFloat()) * 100f
    totalkdchance = if (totalKD > 2.0f) 100f else (totalKD / 2.0f) * 100f
    averagekdchance = if (averageKD > 2.0f) 100f else (averageKD / 2.0f) * 100f
    dprchance = if (dpr > 120f) 100f else (dpr / 120f) * 100
    maxdprchance = if (maxDPR > 120f) 100f else (maxDPR / 120f) * 100f

    CSGOStatsTheme(darkTheme = true) {
        Surface {
            BackHandler(onBack = { activity?.finish() })

            Scaffold(
                content = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "User Stats",
                            modifier = Modifier.padding(48.dp),
                            fontSize = Typography.headlineLarge.fontSize
                        )
                        Card(
                            shape = Shapes.large,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            colors = CardDefaults.cardColors(containerColor = surface)
                        ) {
                            LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                                item {
                                    Card(shape = Shapes.large) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(12.dp),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.SpaceEvenly
                                        ) {
                                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                                Icon(
                                                    painter = painterResource(id = R.drawable.ic_hs),
                                                    contentDescription = "Icon kills",
                                                    modifier = Modifier.requiredSize(32.dp)
                                                )
                                                Text(text = "$kills kills")
                                            }
                                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                                Icon(
                                                    painter = painterResource(id = R.drawable.ic_assist),
                                                    contentDescription = "Icon assists",
                                                    modifier = Modifier.requiredSize(32.dp)
                                                )
                                                Text(text = "$assists assists")
                                            }
                                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                                Icon(
                                                    painter = painterResource(id = R.drawable.ic_death),
                                                    contentDescription = "Icon deaths",
                                                    modifier = Modifier.requiredSize(32.dp)
                                                )
                                                Text(text = "$deaths deaths")
                                            }
                                        }
                                    }
                                }
                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }
                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Average HS%: $hs% of $highestHS%")
                                            }
                                            CustomProgressBar(percentage = hspercent)
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }
                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Highest HS%: $highestHS%")
                                            }
                                            CustomProgressBar(percentage = highestHS)
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Total games as CT start: $startedAsCT out of $totalMatches")

                                            }
                                            CustomProgressBar(percentage = ctchance)
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Average DPR: $dpr")

                                            }
                                            CustomProgressBar(percentage = dprchance)
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Max DPR: $maxDPR")

                                            }
                                            CustomProgressBar(percentage = maxdprchance)
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Total KD: $totalKD")

                                            }
                                            CustomProgressBar(percentage = totalkdchance)
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Average KD per game: $averageKD")

                                            }
                                            CustomProgressBar(percentage = averagekdchance)
                                        }
                                    }
                                }


                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Average MVPs per game: $averageMVPs")

                                            }
                                            CustomProgressBar(percentage = mvppercent)
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Average kills per game: $averageKills")

                                            }
                                            CustomProgressBar(percentage = killpercent)
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Average assists per game: $averageAssists")

                                            }
                                            CustomProgressBar(percentage = assistpercent)
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Average deaths per game: $averageDeaths")

                                            }
                                            CustomProgressBar(percentage = deathpercent)
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Average duration of the game per game: $averageDuration")

                                            }
                                            CustomProgressBar(percentage = durationpercent)
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Total MVPs: $mvps")

                                            }
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Total Duration: $duration minutes")

                                            }
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Highest kill count: $maxKills")

                                            }
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Highest assist count: $maxAssists")

                                            }
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Highest death count: $maxDeath")

                                            }
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Highest MVP count: $maxMVPs")

                                            }
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Highest DPR value: $maxDPR")

                                            }
                                        }
                                    }
                                }

                                item {
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }

                                item {
                                    Card(shape = Shapes.large, modifier = Modifier.fillMaxWidth()) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.padding(4.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(text = "Longest game duration: $maxDuration minutes")

                                            }
                                        }
                                    }
                                }

                            }
                        }
                        Spacer(modifier = Modifier.padding(0.dp, 4.dp))

/*                    Button(
                        onClick = {
                            navController.navigate(Screens.AddStat.route)
                        },
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_add_24),
                                contentDescription = "Icon add"
                            )
                            Text(text = "Add a new match")
                        }

                    }
*/
                        BackHandler(onBack = { activity?.finish() })

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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewUserUI() {
    UserStats(
        navController = NavController(LocalContext.current)
    )
}