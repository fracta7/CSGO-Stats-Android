package com.fracta7.csgostats.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fracta7.csgostats.R
import com.fracta7.csgostats.presentation.add_stats.AddStatScreen
import com.fracta7.csgostats.presentation.main_screen.GeneralStats
import com.fracta7.csgostats.presentation.main_screen.GunStats
import com.fracta7.csgostats.presentation.main_screen.MainScreen
import com.fracta7.csgostats.presentation.main_screen.MapStats
import com.fracta7.csgostats.presentation.match_history.MatchHistory
import com.fracta7.csgostats.presentation.user_stats.UserStats
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = listOf(
        0,
        1,
        2
    )
    val selectedItem = remember { mutableStateOf(items[0]) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(12.dp))
                items.forEach { item ->
                    NavigationDrawerItem(
                        icon = {
                            if (item == 0) Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_verified_24),
                                contentDescription = ""
                            )
                            if (item == 1) Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_analytics_24),
                                contentDescription = ""
                            )
                            if (item == 2) Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_reorder_24),
                                contentDescription = ""
                            )
                        },
                        label = {
                            if (item == 0) Text(text = "Steam Statistics")
                            if (item == 1) Text(text = "User Statistics")
                            if (item == 2) Text(text = "Match History")
                        },
                        selected = item == selectedItem.value,
                        onClick = {
                            selectedItem.value = item
                            if (selectedItem.value == 0) navController.navigate(Screens.MainScreen.route)
                            if (selectedItem.value == 1) navController.navigate(Screens.UserStats.route)
                            if (selectedItem.value == 2) navController.navigate(Screens.MatchHistory.route)
                            scope.launch { drawerState.close() }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Screens.MainScreen.route
                ) {
                    composable(route = Screens.MainScreen.route)
                    {
                        MainScreen(navController = navController)
                    }
                    composable(route = Screens.UserStats.route) {
                        UserStats(navController = navController)
                    }
                    composable(route = Screens.MatchHistory.route)
                    {
                        MatchHistory(navController = navController)
                    }
                    composable(route = Screens.AddStat.route) {
                        AddStatScreen(navController = navController)
                    }
                    composable(route = Screens.GeneralStats.route) {
                        GeneralStats(navController = navController)
                    }
                    composable(route = Screens.GunStats.route) {
                        GunStats()
                    }
                    composable(route = Screens.MapStats.route) {
                        MapStats()
                    }
                }
            }
        }
    )
}

/*    Scaffold(
        content = {


        },
        bottomBar = { NavigationAppBar(navController = navController) },

        )
}*/

@Composable
fun NavigationAppBar(navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Steam Stats", "User Stats", "Match History")

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    if (index == 0) Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_verified_24),
                        contentDescription = "Verified"
                    )
                    if (index == 1) Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_analytics_24),
                        contentDescription = "Analytics"
                    )
                    if (index == 2) Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_reorder_24),
                        contentDescription = "Reorder"
                    )
                },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    if (index == 0) navController.navigate(Screens.MainScreen.route)
                    if (index == 1) navController.navigate(Screens.UserStats.route)
                    if (index == 2) navController.navigate(Screens.MatchHistory.route)
                }
            )
        }
    }
}