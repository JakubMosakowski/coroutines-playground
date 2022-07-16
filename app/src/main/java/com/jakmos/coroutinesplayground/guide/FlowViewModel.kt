package com.jakmos.coroutinesplayground.guide

import androidx.lifecycle.ViewModel

class FlowViewModel : ViewModel() {

    fun onCreate() {

    }

    private fun showLoader() {
        println("Loader shown")
    }

    private fun hideLoader() {
        println("Loader hidden")
    }
}
