package com.fracta7.csgostats.presentation.user_stats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fracta7.csgostats.data.local.UserStatsEntity
import com.fracta7.csgostats.data.repository.UserStatsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserStatsViewModel(private val repository: UserStatsRepository) : ViewModel() {

    private val allStats: Flow<List<UserStatsEntity>> = repository.allStats

    val stats = collectFlow()


    val logic = returnLogic(stats)

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

    private fun returnLogic(stats: List<UserStatsEntity>){

    }
}