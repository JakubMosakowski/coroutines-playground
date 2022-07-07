package com.jakmos.coroutinesplayground.service

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

class ServiceController {

    private val scope = CoroutineScope(
        Dispatchers.Default + SupervisorJob() + CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.v("KUBA", "Thrown: $throwable in context: $coroutineContext")
        }
    )

    private val failingFlow = (0..Int.MAX_VALUE)
        .asSequence()
        .asFlow()
        .onEach { delay(1_000) }

    private val mainFlow = (0..Int.MAX_VALUE)
        .asSequence()
        .asFlow()
        .onEach { delay(3_000) }

    fun onCreate() {
        scope.launch {
            Log.v("KUBA", "Start collecting failing flow")

            failingFlow.collect {
                if (it == 5) throw Exception("Fake network error")
                Log.v("KUBA", "Collected from failing flow: $it ---")
            }
        }

        scope.launch {
            Log.v("KUBA", "Start collecting main flow")

            mainFlow.collect {
                Log.v("KUBA", "Collected from main flow: $it ---")
            }
        }
    }

    fun onDestroy() {
        scope.cancel()
    }
}
