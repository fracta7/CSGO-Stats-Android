package com.fracta7.csgostats.presentation.main_screen


import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.fracta7.csgostats.data.remote.SteamStatApi
import com.fracta7.csgostats.domain.model.JSONModel
import com.fracta7.csgostats.presentation.navigation.Screens
import com.fracta7.csgostats.presentation.ui.theme.CSGOStatsTheme
import com.fracta7.csgostats.presentation.ui.theme.Typography
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun MainScreen(
    navController: NavController
) {
    val activity = LocalContext.current as? Activity
    val context = LocalContext.current
    var text by remember { mutableStateOf("test") }

    CSGOStatsTheme(darkTheme = true) {
        BackHandler(onBack = { activity?.finish() })
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Steam Stats",
                modifier = Modifier.padding(48.dp),
                fontSize = Typography.headlineLarge.fontSize
            )

            Card(modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .clickable {
                    navController.navigate(Screens.GeneralStats.route)
                }) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "General Statistics", modifier = Modifier.padding(12.dp))
                }

            }

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
                                val playerStatsJSON = response.body()?.playerStats?.stats
                                text = playerStatsJSON?.get(0)?.value.toString()
                            }

                            override fun onFailure(call: Call<JSONModel>, t: Throwable) {
                                Toast.makeText(
                                    context, "Something went wrong!", Toast.LENGTH_SHORT
                                ).show()
                                text = "$t"
                            }
                        })
                    })
                    {
                        Text(text = "Load data")
                    }
                    Text(text = text)
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