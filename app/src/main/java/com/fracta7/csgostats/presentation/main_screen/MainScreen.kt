package com.fracta7.csgostats.presentation.main_screen


import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.room.Room
import com.fracta7.csgostats.data.local.AppDatabase
import com.fracta7.csgostats.data.remote.SteamStatApi
import com.fracta7.csgostats.domain.model.JSONModel
import com.fracta7.csgostats.domain.model.Stats
import com.fracta7.csgostats.presentation.ui.theme.CSGOStatsTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

@OptIn(DelicateCoroutinesApi::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MainScreen(
    navController: NavController
) {
    val activity = LocalContext.current as? Activity
    val context = LocalContext.current

    var statsRemote by remember { mutableStateOf(listOf<Stats>()) }


    CSGOStatsTheme(darkTheme = true) {
        BackHandler(onBack = { activity?.finish() })
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                item {
                    Button(onClick = {

                        val retrofit =
                            Retrofit.Builder()
                                .baseUrl(SteamStatApi.BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
                        val steamApi = retrofit.create<SteamStatApi>()
                        val call = steamApi.getSteamStats()
                        call.enqueue(object : Callback<JSONModel> {
                            override fun onResponse(
                                call: Call<JSONModel>,
                                response: Response<JSONModel>
                            ) {
                                statsRemote = response.body()?.playerStats?.stats!!
                            }

                            override fun onFailure(call: Call<JSONModel>, t: Throwable) {
                                Toast.makeText(
                                    context, "Something went wrong! $t", Toast.LENGTH_SHORT
                                ).show()

                            }
                        })
                    })
                    {
                        Text(text = "Load data")
                    }

                }
                items(statsRemote.size) { value ->
                    Text(
                        text = statsRemote[value].name.toString() + ": " + statsRemote[value].value.toString(),
                        modifier = Modifier.padding(4.dp)
                    )
                    Divider(thickness = 1.dp)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMain() {
    val context = LocalContext.current
    CSGOStatsTheme(darkTheme = true) {
        Surface(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            MainScreen(
                navController = NavController(context)

            )
        }

    }

}