package com.example.stopwatch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SWScreen(viewModel : SWViewModel) {
    val time by viewModel.time
    val isRunning by viewModel.isRunning

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = time,
            fontSize = 48.sp,
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)){
            Button(onClick = {
                if (isRunning) viewModel.stop() else viewModel.start()
            },
                modifier = Modifier.width(100.dp)) {
                Text(
                    if (isRunning) "STOP" else "START"
                )
            }
            Button(onClick = { viewModel.reset() },
                modifier = Modifier.width(100.dp)) {
                Text("RESET")
            }
        }
    }
}