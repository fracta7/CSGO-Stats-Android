package com.fracta7.csgostats.presentation.match_history

import com.fracta7.csgostats.domain.model.UserStats

data class MatchHistoryState(
    val userStats: List<UserStats> = emptyList(),
    val openDialog: Boolean = false,
    val isDbEmpty: Boolean = true
)
