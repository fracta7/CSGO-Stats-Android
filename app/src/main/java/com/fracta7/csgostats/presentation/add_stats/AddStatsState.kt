package com.fracta7.csgostats.presentation.add_stats

data class AddStatsState(
    val kills: String = "",
    val assists: String = "",
    val deaths: String = "",
    val hs: String = "",
    val dpr: String = "",
    val mvps: String = "",
    val matchscore: String = "",
    val duration: String = "",
    val date: String = "",
    val map: Int = 0,
    val startedAsCT: Boolean = false,
    val maps: List<String> = listOf(
        "Dust2",
        "Inferno",
        "Mirage",
        "Nuke",
        "Office",
        "Overpass",
        "Train",
        "Vertigo",
        "Other"
    ),
    val selectedMap: String? = null
)
