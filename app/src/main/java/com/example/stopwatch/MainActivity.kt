package com.example.stopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stopwatch.stopwatch.SWScreen
import com.example.stopwatch.weather.WeatherScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val navController = rememberNavController()
            val scope = rememberCoroutineScope()
            enableEdgeToEdge()
            setContent {
                MaterialTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        ModalNavigationDrawer(
                            drawerState = drawerState,
                            drawerContent = {
                                ModalDrawerSheet {
                                    Spacer(modifier = Modifier.height(16.dp))
                                    drawerScreen.forEach { screen ->
                                        NavigationDrawerItem(
                                            label = { Text(screen.title) },
                                            selected = navController.currentDestination?.route == screen.path,
                                            onClick = {
                                                scope.launch {
                                                    drawerState.close()
                                                }
                                                navController.navigate(screen.path)
                                            }
                                        )
                                    }
                                }
                            }
                        )
                        {
                            Scaffold(
                                topBar = {
                                    TopAppBar(
                                        title = { Text("Multi-App") },
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
                                    startDestination = DrawerScreen.Stopwatch.path,
                                    Modifier.padding(paddingValues)
                                ) {
                                    composable(DrawerScreen.Stopwatch.path) { SWScreen() }
                                    composable(DrawerScreen.Weather.path) { WeatherScreen() }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}