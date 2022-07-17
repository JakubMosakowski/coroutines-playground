package com.jakmos.coroutinesplayground.guide

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class JobViewModel : ViewModel() {

    private val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception")
    }
    private val scope: CoroutineScope = CoroutineScope(Job() + handler)

    fun start() {
        scope.launch {
            while (true) {
                if (!isActive) println("First cancelled!")
                delay(1000L)
                println("Printing every second")
            }
        }

        scope.launch {
            while (true) {
                if (!isActive) println("Second cancelled!")
                delay(3000L)
                println("Printing 3 seconds")
//                throw Exception("Smth went wrong")
            }
        }
    }

    fun stop() {
        scope.cancel()
//        scope.coroutineContext.cancelChildren()
    }
}
