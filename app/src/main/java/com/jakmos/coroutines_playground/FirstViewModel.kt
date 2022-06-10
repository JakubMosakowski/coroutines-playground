package com.jakmos.coroutines_playground

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class FirstViewModel : ViewModel() {

    private val sharedFlow = MutableSharedFlow<Int>()
    private val channel = Channel<Int>()

    fun init() {
        emit(1)
        collect()
        emit(2)
    }

    private fun emit(value: Int) = viewModelScope.launch {
        sharedFlow.emit(value)
        channel.send(value)
    }

    private fun collect() {
        viewModelScope.launch {
            Log.v("KUBA", "Start collecting")

            sharedFlow.collect {
                Log.v("KUBA", "Collected from shared flow: $it ---")
            }
        }
        viewModelScope.launch {
            channel.receiveAsFlow().collect {
                Log.v("KUBA", "Collected from channel: $it ---")
            }
        }
    }
}
