package com.jakmos.coroutinesplayground

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class UseCase {

    fun run(scope: CoroutineScope) {
        (0..Int.MAX_VALUE)
            .asSequence()
            .asFlow()
            .onEach { delay(1_000) }
            .onEach { Log.v("KUBA", "On each: $it") }
            .launchIn(scope)
    }
}
