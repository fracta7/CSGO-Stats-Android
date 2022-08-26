package com.fracta7.csgostats.presentation.match_history

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.room.Room
import com.fracta7.csgostats.R
import com.fracta7.csgostats.data.local.AppDatabase
import com.fracta7.csgostats.data.local.UserStatsEntity
import com.fracta7.csgostats.presentation.navigation.Screens
import com.fracta7.csgostats.presentation.ui.theme.*

@Composable
fun MatchHistory(
    navController: NavController
) {
    val activity = LocalContext.current as? Activity
    val db = Room.databaseBuilder(
        LocalContext.current,
        AppDatabase::class.java, "app-database"
    ).allowMainThreadQueries().build()

    val openDialog = remember { mutableStateOf(false) }
    val userStats: List<UserStatsEntity> = db.userStatsDao().getAll()

    CSGOStatsTheme(darkTheme = true) {
        BackHandler(onBack = { activity?.finish() })
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Match History",
                modifier = Modifier.padding(48.dp),
                fontSize = Typography.headlineLarge.fontSize
            )
            Card(
                shape = Shapes.large,
                modifier = Modifier
                    .size(500.dp, 500.dp)
                    .padding(12.dp),
                colors = CardDefaults.cardColors(containerColor = surface)
            ) {
                LazyColumn {
                    items(userStats) { userStat ->
                        MatchCard(
                            map = userStat.map,
                            duration = userStat.duration,
                            date = userStat.date,
                            kills = userStat.kills,
                            assists = userStat.assists,
                            deaths = userStat.deaths,
                            hs = userStat.hs,
                            dpr = userStat.dpr,
                            mvps = userStat.mvps,
                            matchScore = userStat.matchScore
                        )
                    }
                }
            }
            Button(onClick = {
                openDialog.value = true
            }, colors = ButtonDefaults.buttonColors(containerColor = errorContainer)) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_delete_forever_24), contentDescription = "delete", tint = onErrorContainer)
                    Text(text = "Clear History", color = onErrorContainer)
                }

            }
            DialogAlert(navController = navController, db = db, openDialog = openDialog)
        }
    }
    BackHandler(onBack = { activity?.finish() })
}

@Composable
fun MatchCard(
    map: Int?,
    duration: Int?,
    date: String?,
    kills: Int?,
    assists: Int?,
    deaths: Int?,
    hs: Float?,
    dpr: Float?,
    mvps: Int?,
    matchScore: String?
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
            when (map) {
                0 -> painter = R.drawable.map_icon_de_dust2
                1 -> painter = R.drawable.collection_icon_de_inferno
                2 -> painter = R.drawable.map_icon_de_mirage
                3 -> painter = R.drawable.map_icon_de_nuke
                4 -> painter = R.drawable.map_icon_cs_office
                5 -> painter = R.drawable.map_icon_de_overpass
                6 -> painter = R.drawable.map_icon_de_train
                7 -> painter = R.drawable.map_icon_de_vertigo
                8 -> painter = R.drawable.map_icon_lobby_mapveto
            }

            Image(
                painter = painterResource(id = painter),
                contentDescription = "map icon",
                modifier = Modifier

                    .requiredSize(78.dp)
            )

            Column {

                Text(text = "$matchScore", fontSize = Typography.titleLarge.fontSize)
                Text(
                    text = "$duration minutes",
                    fontSize = Typography.labelSmall.fontSize,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "$date",
                    fontSize = Typography.labelSmall.fontSize,
                    fontStyle = FontStyle.Italic
                )
            }

            Column {
                Row {
                    Text(text = "Kills:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = kills.toString())

                }
                Spacer(Modifier.padding(4.dp))
                Row {
                    Text(text = "Deaths:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = deaths.toString())
                }
                Spacer(Modifier.padding(4.dp))
                Row {
                    Text(text = "Assists:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = assists.toString())
                }
            }

            Column {
                Row {
                    Text(text = "HS%:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = "$hs%")

                }
                Spacer(Modifier.padding(4.dp))
                Row {
                    Text(text = "DPR:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = dpr.toString())
                }
                Spacer(Modifier.padding(4.dp))
                Row {
                    Text(text = "MVPs:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = mvps.toString())
                }
            }
        }
    }
}

@Composable
fun DialogAlert(navController: NavController, db: AppDatabase, openDialog: MutableState<Boolean>) {
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
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
                    db.userStatsDao().deleteTable()
                    openDialog.value = false
                    navController.navigate(Screens.MatchHistory.route)
                }) {
                    Text(text = "Delete", color = error)
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    openDialog.value = false
                }) {
                    Text(text = "Cancel")
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview1() {
    CSGOStatsTheme(darkTheme = true) {
        Surface {
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                item {
                    MatchCard(
                        map = R.drawable.collection_icon_de_mirage,
                        duration = 49,
                        date = "17.10.22",
                        kills = 18,
                        assists = 2,
                        deaths = 15,
                        hs = 65f,
                        dpr = 78.9f,
                        mvps = 3,
                        matchScore = "16:9"
                    )
                }
                item {
                    MatchCard(
                        map = R.drawable.collection_icon_de_inferno,
                        duration = 36,
                        date = "01.11.22",
                        kills = 25,
                        assists = 5,
                        deaths = 18,
                        hs = 56f,
                        dpr = 88.9f,
                        mvps = 4,
                        matchScore = "14:16"
                    )
                }
            }

        }
    }
}