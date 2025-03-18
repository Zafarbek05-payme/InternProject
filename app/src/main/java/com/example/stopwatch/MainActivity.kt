package com.example.stopwatch

//noinspection UsingMaterialAndMaterial3Libraries
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stopwatch.stopwatch.SWScreen
import com.example.stopwatch.stopwatch.SWViewModel
import com.example.stopwatch.ui.AppDrawer
import com.example.stopwatch.weather.WeatherScreen
import com.example.stopwatch.weather.WeatherViewModel
import com.example.stopwatch.weather.navigation.MenuItem
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val scope = rememberCoroutineScope()

            MaterialTheme {
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        AppDrawer { route ->
                            scope.launch {
                                drawerState.close()
                                navController.navigate(route)
                            }
                        }
                    }
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text("Mini Apps") },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        scope.launch {
                                            drawerState.open()
                                        }
                                    }) {
                                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                                    }
                                }
                            )
                        }
                    ) { paddingValues ->
                        NavHost(
                            navController = navController,
                            startDestination = MenuItem.Stopwatch.route,
                            Modifier.padding(paddingValues)
                        ) {
                            composable(MenuItem.Stopwatch.route) {
                                val viewModel: SWViewModel = viewModel()
                                SWScreen(viewModel)
                            }
                            composable(MenuItem.Weather.route) {
                                val viewModel: WeatherViewModel = viewModel()
                                WeatherScreen(viewModel)
                            }
                        }
                    }
                }
            }
        }
    }
}