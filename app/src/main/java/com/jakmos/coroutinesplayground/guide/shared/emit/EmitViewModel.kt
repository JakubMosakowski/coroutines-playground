package com.jakmos.coroutinesplayground.guide.shared.emit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jakmos.coroutinesplayground.guide.shared.sampleSharedFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class EmitViewModel : ViewModel() {

    fun emit() = viewModelScope.launch {
        sampleSharedFlow.emit(Random.nextInt())
    }
}
