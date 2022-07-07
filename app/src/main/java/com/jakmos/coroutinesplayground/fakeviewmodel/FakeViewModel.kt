package com.jakmos.coroutinesplayground.fakeviewmodel

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class FakeViewModel {

    private val scope = CoroutineScope(
        Dispatchers.Default + SupervisorJob() + CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.v("KUBA", "Thrown: $throwable in context: $coroutineContext")
        }
    )

    private val flow = (0..Int.MAX_VALUE)
        .asSequence()
        .asFlow()
        .onEach { delay(1_000) }

    fun collect() {
        scope.launch {
            Log.v("KUBA", "Start collecting")

            flow.collect {
                if(it == 5) throw Exception("Fake network error")
                Log.v("KUBA", "Collected from shared flow: $it ---")
            }
        }
    }

    fun onDestroy() {
        scope.cancel()
    }
}
