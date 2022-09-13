package com.fracta7.csgostats.data.remote

import com.fracta7.csgostats.data.remote.dto.JSONModel
import retrofit2.Call
import retrofit2.http.GET

interface SteamStatApi {
    //http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=730&key=6D246C322AF7A2C1D517063C884AE93A&steamid=76561199098153905

    @GET("?appid=$APP_ID&key=$API_KEY&steamid=$STEAM_ID")
    fun getSteamStats(): Call<JSONModel>

    companion object{
        const val API_KEY = "6D246C322AF7A2C1D517063C884AE93A"
        const val STEAM_ID = "76561199098153905"
        const val APP_ID = "730"
        const val BASE_URL = "http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/"
    }
}