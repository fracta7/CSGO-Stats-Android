package com.fracta7.csgostats.presentation.match_history

sealed class MatchHistoryEvent {
    object ToggleDialog : MatchHistoryEvent()
    object ClearHistory : MatchHistoryEvent()
}
