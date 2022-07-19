package com.jakmos.coroutinesplayground.guide

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowViewModel : ViewModel() {

    private val coldFlow = flow {
        (0..Int.MAX_VALUE).forEach { index ->
            delay(1000L)
            emit(index)
        }
    }

    private val hotSharedFlow = MutableSharedFlow<Long>(replay = 0)
    private val hotStateFlow = MutableStateFlow(0L)

    fun emit() = viewModelScope.launch {
        hotSharedFlow.emit(2)
        hotStateFlow.emit(2)
    }

    fun start() {
        viewModelScope.launch {
            coldFlow.collect { value ->
                println("Collected from flow $value!")
            }
        }
        viewModelScope.launch {
            hotSharedFlow.collect { value ->
                println("Collected from shared flow $value!")
            }
        }
        viewModelScope.launch {
            hotStateFlow.collect { value ->
                println("Collected from state flow $value!")
            }
        }
    }
}
