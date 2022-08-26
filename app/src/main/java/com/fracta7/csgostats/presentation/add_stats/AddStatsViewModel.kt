package com.fracta7.csgostats.presentation.add_stats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fracta7.csgostats.data.local.UserStatsEntity
import com.fracta7.csgostats.data.repository.UserStatsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddStatsViewModel(private val repository: UserStatsRepository) : ViewModel() {
    fun insert(stat: UserStatsEntity) = viewModelScope.launch {
        repository.insert(stat)
    }
}