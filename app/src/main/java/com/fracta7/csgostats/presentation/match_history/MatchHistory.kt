package com.fracta7.csgostats.presentation.match_history

import android.annotation.SuppressLint
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun MatchHistory(
    navController: NavController
) {
    val activity = LocalContext.current as? Activity
    var stats by remember{ mutableStateOf(listOf<UserStatsEntity>())}

    val db = Room.databaseBuilder(
        LocalContext.current,
        AppDatabase::class.java, "app-database"
    ).build()
    GlobalScope.launch(Dispatchers.IO) {
        val statsFlow = db.userStatsDao().getAll()

        statsFlow.collect(){
            stats = it
        }
    }

    val openDialog = remember { mutableStateOf(false) }


    CSGOStatsTheme(darkTheme = true) {

        Scaffold(content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                /*Text(
                    text = "Match History",
                    modifier = Modifier.padding(48.dp),
                    fontSize = Typography.headlineLarge.fontSize
                )*/
                Card(
                    shape = Shapes.large,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    colors = CardDefaults.cardColors(containerColor = surface)
                ) {
                    LazyColumn {
                        items(stats) { userStat ->
                            MatchCard(
                                userStat
                            )
                        }
                    }
                }
/*                Button(
                    onClick = {
                        openDialog.value = true
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = errorContainer),
                    modifier = Modifier.padding(12.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_delete_forever_24),
                            contentDescription = "delete",
                            tint = onErrorContainer
                        )
                        Text(text = "Clear History", color = onErrorContainer)
                    }

                } */
                DialogAlert(navController = navController, db = db, openDialog = openDialog)
            }
        },
            floatingActionButton = {
                Button(
                    onClick = {
                        openDialog.value = true
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = errorContainer),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_delete_forever_24),
                        contentDescription = "delete",
                        tint = onErrorContainer
                    )
                }
            })


    }
    BackHandler(onBack = { activity?.finish() })
}

@Composable
fun MatchCard(
    userStatsEntity: UserStatsEntity
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
            when (userStatsEntity.map) {
                0 -> painter = R.drawable.collection_icon_de_dust2
                1 -> painter = R.drawable.collection_icon_de_inferno
                2 -> painter = R.drawable.collection_icon_de_mirage
                3 -> painter = R.drawable.collection_icon_de_nuke
                4 -> painter = R.drawable.collection_icon_cs_office
                5 -> painter = R.drawable.collection_icon_de_overpass
                6 -> painter = R.drawable.collection_icon_de_train
                7 -> painter = R.drawable.collection_icon_de_vertigo
                8 -> painter = R.drawable.collection_icon_none
            }

            Image(
                painter = painterResource(id = painter),
                contentDescription = "map icon",
                modifier = Modifier

                    .requiredSize(78.dp)
            )

            Column {

                Text(text = "${userStatsEntity.matchScore}", fontSize = Typography.titleLarge.fontSize)
                Text(
                    text = "${userStatsEntity.duration} minutes",
                    fontSize = Typography.labelSmall.fontSize,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "${userStatsEntity.date}",
                    fontSize = Typography.labelSmall.fontSize,
                    fontStyle = FontStyle.Italic
                )
            }

            Column {
                Row {
                    Text(text = "Kills:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = userStatsEntity.kills.toString())

                }
                Spacer(Modifier.padding(4.dp))
                Row {
                    Text(text = "Deaths:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = userStatsEntity.deaths.toString())
                }
                Spacer(Modifier.padding(4.dp))
                Row {
                    Text(text = "Assists:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = userStatsEntity.assists.toString())
                }
            }

            Column {
                Row {
                    Text(text = "HS%:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = "${userStatsEntity.hs}%")

                }
                Spacer(Modifier.padding(4.dp))
                Row {
                    Text(text = "DPR:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = userStatsEntity.dpr.toString())
                }
                Spacer(Modifier.padding(4.dp))
                Row {
                    Text(text = "MVPs:")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = userStatsEntity.mvps.toString())
                }
            }
        }
    }
}

@OptIn(DelicateCoroutinesApi::class)
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
                    GlobalScope.launch {
                        db.userStatsDao().deleteTable()
                    }
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
    CSGOStatsTheme(darkTheme = true){

    }
}