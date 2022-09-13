package com.fracta7.csgostats.presentation.add_stats

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.fracta7.csgostats.domain.repository.UserStatsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
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
                }

                val isInputEmpty =
                    (state.kills == "" || state.duration == "" || state.assists == "" || state.deaths == "" || state.mvps == "" || state.matchscore == "" || state.date == "")
                if (!isInputEmpty) {
                    if (state.hs == "") state = state.copy(hs = "0")
                    if (state.dpr == "") state = state.copy(dpr = "0")
                }

            }
        }
    }
}