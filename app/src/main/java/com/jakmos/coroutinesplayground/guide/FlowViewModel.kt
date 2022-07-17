package com.jakmos.coroutinesplayground.guide

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowViewModel : ViewModel() {

    private val flow = flow {
        (0..Int.MAX_VALUE).forEach { index ->
            delay(1000L)
            emit(index)
        }
    }

    private val sharedFlow = MutableSharedFlow<Long>(replay = 10)
    private val stateFlow = MutableStateFlow(0L)

    fun emit() = viewModelScope.launch {
        sharedFlow.emit(2)
        stateFlow.emit(2)
    }

    fun start() {
        viewModelScope.launch {
            flow.collect { value ->
                println("Collected from flow $value!")
            }
        }
        viewModelScope.launch {
            sharedFlow.collect { value ->
                println("Collected from shared flow $value!")
            }
        }
        viewModelScope.launch {
            stateFlow.collect { value ->
                println("Collected from state flow $value!")
            }
        }
    }
}
