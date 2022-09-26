package com.fracta7.csgostats.presentation.add_stats

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fracta7.csgostats.domain.model.UserStats
import com.fracta7.csgostats.domain.repository.UserStatsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddStatsViewModel @Inject constructor(
    private val repository: UserStatsRepository
) : ViewModel() {
    var state by mutableStateOf(AddStatsState())

    fun onEvent(event: AddStatsEvent) {
        when (event) {
            is AddStatsEvent.AddStat -> {
                when (state.selectedMap) {
                    state.maps[0] -> state = state.copy(map = 0)
                    state.maps[1] -> state = state.copy(map = 1)
                    state.maps[2] -> state = state.copy(map = 2)
                    state.maps[3] -> state = state.copy(map = 3)
                    state.maps[4] -> state = state.copy(map = 4)
                    state.maps[5] -> state = state.copy(map = 5)
                    state.maps[6] -> state = state.copy(map = 6)
                    state.maps[7] -> state = state.copy(map = 7)
                    state.maps[8] -> state = state.copy(map = 8)
                    state.maps[9] -> state = state.copy(map = 9)
                    state.maps[10] -> state = state.copy(map = 10)
                    state.maps[11] -> state = state.copy(map = 11)
                    state.maps[12] -> state = state.copy(map = 12)
                    state.maps[13] -> state = state.copy(map = 13)
                    state.maps[14] -> state = state.copy(map = 14)
                    state.maps[15] -> state = state.copy(map = 15)
                    state.maps[16] -> state = state.copy(map = 16)
                }
                if (state.kills == "") state = state.copy(isKillEmpty = true)
                if (state.assists == "") state = state.copy(isAssistEmpty = true)
                if (state.deaths == "") state = state.copy(isDeathEmpty = true)
                if (state.hs == "") state = state.copy(isHSEmpty = true)
                if (state.dpr == "") state = state.copy(isDPREmpty = true)
                if (state.day == "") state = state.copy(isDayEmpty = true)
                if (state.month == "") state = state.copy(isMonthEmpty = true)
                if (state.year == "") state = state.copy(isYearEmpty = true)
                if (state.mvps == "") state = state.copy(isMVPEmpty = true)
                if (state.duration == "") state = state.copy(isDurationEmpty = true)
                if (state.score1 == "") state = state.copy(isScore1Empty = true)
                if (state.score2 == "") state = state.copy(isScore2Empty = true)
                val inputEmpty =
                    state.isKillEmpty ||
                            state.isAssistEmpty ||
                            state.isDeathEmpty ||
                            state.isHSEmpty ||
                            state.isDPREmpty ||
                            state.isDayEmpty ||
                            state.isMonthEmpty ||
                            state.isYearEmpty ||
                            state.isMVPEmpty ||
                            state.isDurationEmpty ||
                            state.isScore1Empty ||
                            state.isScore2Empty

                if (!inputEmpty) {
                    state = state.copy(
                        noError = true,
                        date = "${state.day}.${state.month}.${state.year}",
                        matchscore = "${state.score1}:${state.score2}"
                    )
                    viewModelScope.launch {
                        repository.insert(
                            UserStats(
                                map = state.map,
                                duration = state.duration.toInt(),
                                date = state.date,
                                kills = state.kills.toInt(),
                                assists = state.assists.toInt(),
                                deaths = state.deaths.toInt(),
                                hs = state.hs.toFloat(),
                                dpr = state.dpr.toFloat(),
                                mvps = state.mvps.toInt(),
                                matchScore = state.matchscore,
                                startedAsCT = state.startedAsCT
                            )
                        )
                    }
                }
            }
        }
    }
}