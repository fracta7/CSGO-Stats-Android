package com.fracta7.csgostats.presentation.add_stats

import android.annotation.SuppressLint
import android.widget.Toast
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import com.fracta7.csgostats.data.local.AppDatabase
import com.fracta7.csgostats.data.local.UserStatsEntity
import com.fracta7.csgostats.presentation.ui.theme.CSGOStatsTheme
import com.fracta7.csgostats.presentation.ui.theme.Shapes
import com.fracta7.csgostats.presentation.ui.theme.surfaceVariant
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

var selectedMap: String? = null

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun AddStatScreen(navController: NavController) {
    val maps = listOf(
        "Dust2",
        "Inferno",
        "Mirage",
        "Nuke",
        "Office",
        "Overpass",
        "Train",
        "Vertigo",
        "Other"
    )

    var kills by remember { mutableStateOf("") }
    var assists by remember { mutableStateOf("") }
    var deaths by remember { mutableStateOf("") }
    var hs by remember { mutableStateOf("") }
    var dpr by remember { mutableStateOf("") }
    var mvps by remember { mutableStateOf("") }
    var matchscore by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var map: Int? = 0
    var startedAsCT by remember { mutableStateOf(false) }
    val context = LocalContext.current

    val db = Room.databaseBuilder(
        LocalContext.current,
        AppDatabase::class.java, "app-database"
    ).build()

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
                        value = kills,
                        onValueChange = { kills = it },
                        modifier = modifier,
                        label = { Text(text = "Kills") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large
                    )
                }

                item {

                    OutlinedTextField(
                        value = assists,
                        onValueChange = { assists = it },
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
                        value = deaths,
                        onValueChange = { deaths = it },
                        modifier = modifier,
                        label = { Text(text = "Deaths") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large
                    )
                }

                item {

                    OutlinedTextField(
                        value = hs,
                        onValueChange = { hs = it },
                        modifier = modifier,
                        label = { Text(text = "HS%") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large
                    )
                }

                item {

                    OutlinedTextField(
                        value = dpr,
                        onValueChange = { dpr = it },
                        modifier = modifier,
                        label = { Text(text = "DPR") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large
                    )
                }

                item {

                    OutlinedTextField(
                        value = mvps,
                        onValueChange = { mvps = it },
                        modifier = modifier,
                        label = { Text(text = "MVPs") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large
                    )
                }

                item {

                    OutlinedTextField(
                        value = matchscore,
                        onValueChange = { matchscore = it },
                        modifier = modifier,
                        label = { Text(text = "Match Score") },
                        shape = Shapes.large
                    )
                }

                item {

                    OutlinedTextField(
                        value = duration,
                        onValueChange = { duration = it },
                        modifier = modifier,
                        label = { Text(text = "Duraiton") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = Shapes.large
                    )
                }

                item {

                    OutlinedTextField(
                        value = date,
                        onValueChange = { date = it },
                        modifier = modifier,
                        label = { Text(text = "Date") },
                        shape = Shapes.large
                    )
                }
                item {
                    DropdownList(items = maps)
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Started as CT?", Modifier.padding(end = 8.dp))
                        Checkbox(checked = startedAsCT, onCheckedChange = { startedAsCT = it })
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

                when (selectedMap) {
                    maps[0] -> map = 0
                    maps[1] -> map = 1
                    maps[2] -> map = 2
                    maps[3] -> map = 3
                    maps[4] -> map = 4
                    maps[5] -> map = 5
                    maps[6] -> map = 6
                    maps[7] -> map = 7
                    maps[8] -> map = 8
                }

                val isInputEmpty =
                    (kills == "" || duration == "" || assists == "" || deaths == "" || mvps == "" || matchscore == ""||date=="")
                if (!isInputEmpty) {
                    if (hs == "") hs = "0"
                    if (dpr == "") dpr = "0"
                    GlobalScope.launch {
                        db.userStatsDao().insertAll(
                            UserStatsEntity(
                                kills = kills.toInt(),
                                map = map,
                                duration = duration.toInt(),
                                date = date,
                                assists = assists.toInt(),
                                deaths = deaths.toInt(),
                                hs = hs.toFloat(),
                                dpr = dpr.toFloat(),
                                mvps = mvps.toInt(),
                                matchScore = matchscore,
                                startedAsCT = startedAsCT
                            )
                        )
                    }
                    navController.popBackStack()
                } else{
                    Toast.makeText(context, "Input is empty!", Toast.LENGTH_SHORT).show()
                }


            }) {
                Text(text = "Add")
            }
        }
    }
}

@Composable
fun DropdownList(items: List<String>) {

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
            Text(text = text, fontSize = 18.sp, modifier = Modifier.padding(end = 8.dp))
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "dropdown arrow")
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                items.forEach { item ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        text = item
                        selectedMap = text
                    }, text = { Text(text = item) })
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewAdd() {
    CSGOStatsTheme(darkTheme = true) {
        Surface() {

        }
    }
}