package com.fracta7.csgostats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import com.fracta7.csgostats.data.local.AppDatabase
import com.fracta7.csgostats.data.repository.SteamStatsRepository
import com.fracta7.csgostats.data.repository.UserStatsRepository
import com.fracta7.csgostats.presentation.navigation.Navigation
import com.fracta7.csgostats.presentation.ui.theme.CSGOStatsTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CSGOStatsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {

                    Navigation()

                }
            }
        }
    }
}