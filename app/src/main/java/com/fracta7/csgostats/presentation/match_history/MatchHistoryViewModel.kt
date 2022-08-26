package com.fracta7.csgostats.presentation.match_history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fracta7.csgostats.data.local.UserStatsEntity
import com.fracta7.csgostats.data.repository.UserStatsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MatchHistoryViewModel(private val repository: UserStatsRepository): ViewModel() {
    private val allStats: Flow<List<UserStatsEntity>> = repository.allStats

    val stats = collectFlow()

    fun insert(stat: UserStatsEntity) = viewModelScope.launch {
        repository.insert(stat)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    private fun collectFlow(): List<UserStatsEntity>{
        var stat: List<UserStatsEntity> = listOf()
        viewModelScope.launch {
            allStats.collect{
                stat = it
                return@collect
            }
        }
        return stat
    }

}