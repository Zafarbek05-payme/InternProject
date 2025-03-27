package com.example.miniapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.miniapps.ui.NavDrawer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme{
                Surface(
                    color = MaterialTheme.colorScheme.background
                ){
                    NavDrawer()
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewNav(modifier: Modifier = Modifier) {
    NavDrawer()
}


