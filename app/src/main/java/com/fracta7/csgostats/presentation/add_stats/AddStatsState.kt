package com.fracta7.csgostats.presentation.add_stats

data class AddStatsState(
    val kills: String = "",
    val assists: String = "",
    val deaths: String = "",
    val hs: String = "",
    val dpr: String = "",
    val mvps: String = "",
    val matchscore: String = "",
    val score1: String = "",
    val score2: String = "",
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
        "Agency",
        "Ancient",
        "Cache",
        "Cobblestone",
        "Lake",
        "Safe House",
        "Short Dust",
        "Short Nuke",
        "Other"
    ),
    val selectedMap: String? = null,
    val isKillEmpty: Boolean = false,
    val isDeathEmpty: Boolean = false,
    val isAssistEmpty: Boolean = false,
    val isHSEmpty: Boolean = false,
    val isDPREmpty: Boolean = false,
    val isMVPEmpty: Boolean = false,
    val isScore1Empty: Boolean = false,
    val isScore2Empty: Boolean = false,
    val isDurationEmpty: Boolean = false,
    val isDayEmpty: Boolean = false,
    val isMonthEmpty: Boolean = false,
    val isYearEmpty: Boolean = false,
    val day: String = "",
    val month: String = "",
    val year: String = "",
    val noError: Boolean = false
)
