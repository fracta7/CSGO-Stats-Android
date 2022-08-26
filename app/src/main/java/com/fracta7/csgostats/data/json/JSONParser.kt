package com.fracta7.csgostats.data.json

import java.io.InputStream

interface JSONParser<T> {
    suspend fun parse(stream: InputStream): List<T>
}