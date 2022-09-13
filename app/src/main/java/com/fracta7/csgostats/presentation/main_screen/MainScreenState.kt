package com.fracta7.csgostats.presentation.main_screen

import com.fracta7.csgostats.domain.model.Stats

data class MainScreenState(
    val stats: List<Stats> = emptyList(),
    val callSucceeded: Boolean = true,
    val status: String = ""
)
