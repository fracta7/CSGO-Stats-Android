package com.fracta7.csgostats.presentation.navigation

sealed class Screens(val route: String) {
    object MainScreen : Screens("main_screen")
    object UserStats : Screens("user_stats_screen")
    object MatchHistory : Screens("match_history_screen")
    object AddStat: Screens("add_stats")
    object GeneralStats: Screens("general_stats")
    object GunStats: Screens("gun_stats")
    object MapStats: Screens("map_stats")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}