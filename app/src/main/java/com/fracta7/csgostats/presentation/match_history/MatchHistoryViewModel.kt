package com.fracta7.csgostats.presentation.match_history

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fracta7.csgostats.domain.repository.UserStatsRepository
import com.fracta7.csgostats.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchHistoryViewModel @Inject constructor(
    private val repository: UserStatsRepository
) : ViewModel() {
    var state by mutableStateOf(MatchHistoryState())

    init {
        viewModelScope.launch {
            repository.getUserStats().collect {
                when (it) {
                    is Resource.Success -> {
                        state =
                            it.data?.let { it1 -> state.copy(userStats = it1, isDbEmpty = false) }!!
                    }
                    is Resource.Loading -> Unit
                    is Resource.Error -> {
                        state = state.copy(isDbEmpty = true)
                    }
                }
            }
        }
    }

    fun onEvent(event: MatchHistoryEvent) {
        when (event) {
            is MatchHistoryEvent.ToggleDialog -> {
                state = state.copy(openDialog = !state.openDialog)
            }
            is MatchHistoryEvent.ClearHistory -> {
                state = state.copy(userStats = emptyList(), openDialog = !state.openDialog)
                viewModelScope.launch {
                    repository.clearMatches()
                }
            }
        }
    }

}