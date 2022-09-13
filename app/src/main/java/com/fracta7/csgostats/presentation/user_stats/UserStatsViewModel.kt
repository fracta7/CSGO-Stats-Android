package com.fracta7.csgostats.presentation.user_stats

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
class UserStatsViewModel @Inject constructor(
    private val repository: UserStatsRepository
) : ViewModel() {

    var state by mutableStateOf(UserStatsState())
    var stats: List<UserStats> = emptyList()

    init {
        viewModelScope.launch {
            repository.getUserStats().collect { it ->
                when (it) {
                    is Resource.Success -> {
                        stats = it.data!!
                        val totalMatches = stats.size
                        var kills = 0
                        var assists = 0
                        var deaths = 0
                        var hs = 0f

                        var mvps = 0
                        var startedAsCT = 0
                        var duration = 0
                        var maxKills = 0
                        var maxDeath = 0
                        var maxAssists = 0
                        var highestHS = 0f
                        var maxMVPs = 0
                        var maxDPR = 0f
                        var maxDuration = 0
                        var ctchance = 0f
                        var hspercent = 0f
                        var mvppercent = 0f
                        var killpercent = 0f
                        var assistpercent = 0f
                        var deathpercent = 0f
                        var durationpercent = 0f

                        var dpr = stats[0].dpr!!
                        var averageKD = stats[0].kills!!.toFloat() / stats[0].deaths!!.toFloat()
                        var averageKills = stats[0].kills!!.toFloat()
                        var averageAssists = stats[0].assists!!.toFloat()
                        var averageDeaths = stats[0].deaths!!.toFloat()
                        var averageMVPs = stats[0].mvps!!.toFloat()
                        var averageDuration = stats[0].duration!!.toFloat()

                        stats.forEach { it1 ->
                            kills += it1.kills!!
                            assists += it1.assists!!
                            deaths += it1.deaths!!
                            hs = (hs + it1.hs!!) / 2
                            dpr = (dpr + it1.dpr!!) / 2
                            mvps += it1.mvps!!
                            duration += it1.duration!!
                            if (it1.startedAsCT == true) startedAsCT++
                            averageKD = (averageKD + (it1.kills.toFloat() / deaths.toFloat())) / 2
                            averageKills = (averageKills + it1.kills.toFloat()) / 2
                            averageAssists = (averageAssists + it1.assists.toFloat()) / 2
                            averageDeaths = (averageDeaths + it1.deaths.toFloat()) / 2
                            averageMVPs = (averageMVPs + it1.mvps.toFloat()) / 2
                            averageDuration = (averageDuration + it1.duration.toFloat()) / 2
                            if (it1.kills > maxKills) maxKills = it1.kills
                            if (it1.deaths > maxDeath) maxDeath = it1.deaths
                            if (it1.assists > maxAssists) maxAssists = it1.assists
                            if (it1.mvps > maxMVPs) maxMVPs = it1.mvps
                            if (it1.hs > highestHS) highestHS = it1.hs
                            if (it1.dpr > maxDPR) maxDPR = it1.dpr
                            if (it1.duration > maxDuration) maxDuration = it1.duration
                        }
                        val totalKD = kills.toFloat() / deaths.toFloat()

                        if (totalMatches != 0) ctchance =
                            (startedAsCT.toFloat() / totalMatches.toFloat()) * 100f
                        if (totalMatches != 0) hspercent = (hs / highestHS) * 100f
                        if (totalMatches != 0) mvppercent = (averageMVPs / mvps.toFloat()) * 100f
                        if (totalMatches != 0) killpercent = (averageKills / kills.toFloat()) * 100f
                        if (totalMatches != 0) assistpercent =
                            (averageAssists / assists.toFloat()) * 100f
                        if (totalMatches != 0) deathpercent =
                            (averageDeaths / deaths.toFloat()) * 100f
                        if (totalMatches != 0) durationpercent =
                            (averageDuration / duration.toFloat()) * 100f
                        val totalkdchance = if (totalKD > 2.0f) 100f else (totalKD / 2.0f) * 100f
                        val averagekdchance =
                            if (averageKD > 2.0f) 100f else (averageKD / 2.0f) * 100f
                        val dprchance = if (dpr > 120f) 100f else (dpr / 120f) * 100
                        val maxdprchance = if (maxDPR > 120f) 100f else (maxDPR / 120f) * 100f
                        state = state.copy(
                            stats = stats,
                            totalMatches = totalMatches,
                            kills = kills,
                            assists = assists,
                            deaths = deaths,
                            hs = hs,
                            dpr = dpr,
                            mvps = mvps,
                            startedAsCt = startedAsCT,
                            duration = duration,
                            totalKD = totalKD,
                            averageKD = averageKD,
                            averageKills = averageKills,
                            averageDeaths = averageDeaths,
                            averageAssists = averageAssists,
                            averageMVPs = averageMVPs,
                            averageDuration = averageDuration,
                            maxKills = maxKills,
                            maxDeath = maxDeath,
                            maxAssists = maxAssists,
                            highestHS = highestHS,
                            maxMVPs = maxMVPs,
                            maxDPR = maxDPR,
                            maxDuration = maxDuration,
                            ctchance = ctchance,
                            hspercent = hspercent,
                            mvppercent = mvppercent,
                            killpercent = killpercent,
                            assistpercent = assistpercent,
                            deathpercent = deathpercent,
                            durationpercent = durationpercent,
                            totalkdchance = totalkdchance,
                            averagekdchance = averagekdchance,
                            dprchance = dprchance,
                            maxdprchance = maxdprchance
                        )
                    }
                    is Resource.Error -> {

                    }
                    is Resource.Loading -> {

                    }
                }
            }
        }
    }

    fun onEvent(event: UserStatsEvent) {
        when (event) {
            is UserStatsEvent.AddStats -> {

            }
        }
    }
}