package com.fracta7.csgostats.data.mapper

import com.fracta7.csgostats.data.local.UserStatsEntity
import com.fracta7.csgostats.domain.model.UserStats

fun UserStatsEntity.toUserStats(): UserStats {
    return UserStats(
        map = map,
        duration = duration,
        date = date,
        kills = kills,
        assists = assists,
        deaths = deaths,
        hs = hs,
        dpr = dpr,
        mvps = mvps,
        matchScore = matchScore,
        startedAsCT = startedAsCT
    )
}

fun UserStats.toUserStatsEntity(): UserStatsEntity {
   return UserStatsEntity(
      map = map,
      duration = duration,
      date = date,
      kills = kills,
      assists = assists,
      deaths = deaths,
      hs = hs,
      dpr = dpr,
      mvps = mvps,
      matchScore = matchScore,
      startedAsCT = startedAsCT
   )
}