package com.example.miniapps.stopwatch

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SWViewModel : ViewModel() {
    private var startTime: Long = 0
    private var elapsedTime: Long = 0
    private var task: Job? = null

    var time = mutableStateOf("00:00:00")
    var isRunning = mutableStateOf(false)
    var lapsList = MutableStateFlow<MutableList<String>>(mutableListOf())

    fun start(){
        if (!isRunning.value) {
            isRunning.value = true
            startTime = System.currentTimeMillis() - elapsedTime
            task = viewModelScope.launch {
                while (isRunning.value) {
                    elapsedTime = System.currentTimeMillis() - startTime
                    time.value = formatTime(elapsedTime)
                    delay(1)
                }
            }
        }
    }

    fun stop(){
        isRunning.value = false
        task?.cancel()
    }

    fun reset(){
        isRunning.value = false
        task?.cancel()
        elapsedTime = 0
        time.value = "00:00:00"
    }

    fun addLap() {
        if (isRunning.value){
            val lapTime = System.currentTimeMillis() - startTime
            lapsList.value.add(formatTime(lapTime))
        }
    }

    @SuppressLint("DefaultLocale")
    private fun formatTime(ms: Long): String {
        val hours = ms/3600000
        val minutes = ms % 3600000 / 60000
        val seconds = ms % 60000 / 1000
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }
}