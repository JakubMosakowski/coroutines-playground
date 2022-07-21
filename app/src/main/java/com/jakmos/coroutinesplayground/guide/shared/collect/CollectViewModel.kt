package com.jakmos.coroutinesplayground.guide.shared.collect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jakmos.coroutinesplayground.guide.shared.sampleSharedFlow
import kotlinx.coroutines.launch

class CollectViewModel : ViewModel() {

    fun collect() = viewModelScope.launch {
        sampleSharedFlow.collect {
            println("Collected \"$it\" in CollectViewModel")
        }
    }
}
