package com.example.miniapps.ui

//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
 import android.annotation.SuppressLint
 import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
 import androidx.compose.material.icons.Icons
 import androidx.compose.material.icons.filled.Menu
 import androidx.compose.material3.DrawerValue
 import androidx.compose.material3.Icon
 import androidx.compose.material3.MaterialTheme
 import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
 import androidx.compose.material3.Text
 import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
 import androidx.navigation.compose.NavHost
 import androidx.navigation.compose.composable
 import androidx.navigation.compose.rememberNavController
 import com.example.miniapps.apps.news.presentation.NewsScreen
 import com.example.miniapps.apps.stopwatch.SWScreen
 import com.example.miniapps.apps.weather.WeatherScreen
 import com.example.miniapps.navigation.Screens
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavDrawer(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    Modifier
                        .background(MaterialTheme.colorScheme.onBackground)
                        .fillMaxWidth()
                        .padding(32.dp)
                ){
                    Text(
                        "Mini Apps",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Divider()
                NavigationDrawerItem(
                    modifier = Modifier.padding(16.dp),
                    label = { Text("Stopwatch") },
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screens.Stopwatch.screen){
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    label = { Text("Weather") },
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screens.Weather.screen){
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    label = { Text("News") },
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screens.News.screen){
                            popUpTo(0)
                        }
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar(
                    title = { Text(text = "Mini Apps", color = Color.White) },
                    backgroundColor = MaterialTheme.colorScheme.onBackground,
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }){
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }

                )
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = Screens.Weather.screen
            ){
                composable(Screens.Stopwatch.screen){ SWScreen() }
                composable(Screens.Weather.screen){ WeatherScreen() }
                composable(Screens.News.screen){ NewsScreen() }
            }
        }
    }
}
