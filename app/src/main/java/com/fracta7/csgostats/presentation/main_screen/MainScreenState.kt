package com.fracta7.csgostats.presentation.main_screen

import com.fracta7.csgostats.domain.model.UserStats

data class MainScreenState(
    val stats: List<UserStats> = emptyList(),
    val status: String = "",
    val showStats: Boolean = false
)
