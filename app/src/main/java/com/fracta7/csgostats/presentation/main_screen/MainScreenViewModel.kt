package com.fracta7.csgostats.presentation.main_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fracta7.csgostats.domain.model.UserStats
import com.fracta7.csgostats.domain.repository.UserStatsRepository
import com.fracta7.csgostats.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: UserStatsRepository
) : ViewModel() {
    var state by mutableStateOf(MainScreenState())

    init {
        viewModelScope.launch {
            loadStats()
        }
    }

    suspend fun loadStats() {
        repository.getUserStats().collect {
            state = when (it) {
                is Resource.Error -> {
                    state.copy(status = "Error", showStats = false)
                }
                is Resource.Loading -> {
                    state.copy(status = "Loading", showStats = false)
                }
                is Resource.Success -> {
                    state.copy(status = "Done", stats = it.data!!, showStats = true)
                }
            }
        }
    }
}
