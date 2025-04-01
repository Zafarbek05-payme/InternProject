package com.example.miniapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import com.example.miniapps.ui.NavDrawer
import com.example.miniapps.ui.theme.StopwatchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            StopwatchTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ){
                    NavDrawer()
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun PreviewNav(modifier: Modifier = Modifier) {
//    NavDrawer()
//}


