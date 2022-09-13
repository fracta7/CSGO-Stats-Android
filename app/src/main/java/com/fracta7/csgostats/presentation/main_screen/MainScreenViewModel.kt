package com.fracta7.csgostats.presentation.main_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.fracta7.csgostats.data.mapper.toStats
import com.fracta7.csgostats.data.remote.SteamStatApi
import com.fracta7.csgostats.data.remote.dto.JSONModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val steamStatApi: SteamStatApi
) : ViewModel() {
    var state by mutableStateOf(MainScreenState())

    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.NetworkCall -> {
                steamStatApi.getSteamStats().enqueue(object : Callback<JSONModel> {
                    override fun onResponse(call: Call<JSONModel>, response: Response<JSONModel>) {
                        val remoteData = response.body()?.playerStats?.stats?.map { it.toStats() }
                        state = remoteData?.let { state.copy(stats = it, callSucceeded = true, status = "Loaded") }!!
                    }

                    override fun onFailure(call: Call<JSONModel>, t: Throwable) {
                        state = state.copy(callSucceeded = false, status = "An error occurred. $t")
                    }
                })
            }
        }
    }
}