package com.fracta7.csgostats.data.mapper

import com.fracta7.csgostats.data.remote.dto.StatsDto
import com.fracta7.csgostats.domain.model.Stats

fun StatsDto.toStats(): Stats{
    return Stats(
        name = name,
        value = value
    )
}