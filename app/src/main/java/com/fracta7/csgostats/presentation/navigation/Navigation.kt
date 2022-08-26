package com.fracta7.csgostats.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fracta7.csgostats.R
import com.fracta7.csgostats.presentation.add_stats.AddStatScreen
import com.fracta7.csgostats.presentation.main_screen.GeneralStats
import com.fracta7.csgostats.presentation.main_screen.GunStats
import com.fracta7.csgostats.presentation.main_screen.MainScreen
import com.fracta7.csgostats.presentation.main_screen.MapStats
import com.fracta7.csgostats.presentation.match_history.MatchHistory
import com.fracta7.csgostats.presentation.user_stats.UserStats

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation() {
    val navController = rememberNavController()
    Scaffold(
        content = {
            Column(modifier = Modifier.fillMaxWidth().padding(2.dp)) {
                NavHost(navController = navController, startDestination = Screens.MainScreen.route) {
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
                    composable(route = Screens.GeneralStats.route){
                        GeneralStats(navController = navController)
                    }
                    composable(route = Screens.GunStats.route){
                        GunStats()
                    }
                    composable(route = Screens.MapStats.route){
                        MapStats()
                    }
                }
            }

        },
        bottomBar = { NavigationAppBar(navController = navController) },

    )
}

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