package com.example.miniapps.apps.stopwatch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

// TODO = viewModel() -> hiltViewModel()
@Composable
fun SWScreen(viewModel: SWViewModel = viewModel()) {
    val time by viewModel.time
    val isRunning by viewModel.isRunning
    val lapList by viewModel.lapsList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = time,
            fontSize = 48.sp,
            style = MaterialTheme.typography.labelLarge
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(
                onClick = {
                    if (isRunning) viewModel.stop() else viewModel.start()
                },
                modifier = Modifier.width(100.dp)
            ) {
                Text(
                    if (isRunning) "STOP" else "START"
                )
            }
            Button(
                onClick = { viewModel.reset() },
                modifier = Modifier.width(100.dp)
            ) {
                Text("RESET")
            }
            Button(
                onClick = { viewModel.addLap() },
                modifier = Modifier.width(100.dp)
            ) {
                Text("LAP")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (lapList.isNotEmpty()) {
                for (lap in lapList) {
                    Text("Lap ${lapList.indexOf(lap) + 1}: $lap")
                }
                Button(onClick = { lapList.clear() }) {
                    Text("CLEAR LAPS")
                }
            }
        }
    }
}

@Preview
@Composable
fun PrevSW(modifier: Modifier = Modifier) {
    SWScreen()
}
