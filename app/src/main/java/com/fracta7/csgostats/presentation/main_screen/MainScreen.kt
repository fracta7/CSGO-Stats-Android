package com.fracta7.csgostats.presentation.main_screen


import android.annotation.SuppressLint
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.fracta7.csgostats.presentation.ui.theme.CSGOStatsTheme

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MainScreen(
    navController: NavController
) {
    val activity = LocalContext.current as? Activity
    val viewModel = hiltViewModel<MainScreenViewModel>()

    CSGOStatsTheme(darkTheme = true) {
        BackHandler(onBack = { activity?.finish() })
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                item {
                    Button(onClick = {
                        viewModel.onEvent(MainScreenEvent.NetworkCall)
                    })
                    {
                        Text(text = "Load data")
                    }

                }
                item {
                    Text(text = viewModel.state.status)
                }
                items(viewModel.state.stats.size) { value ->
                    Text(
                        text = viewModel.state.stats[value].name.toString() + ": " + viewModel.state.stats[value].value.toString(),
                        modifier = Modifier.padding(4.dp)
                    )
                    Divider(thickness = 1.dp)
                }
            }
        }
    }
}