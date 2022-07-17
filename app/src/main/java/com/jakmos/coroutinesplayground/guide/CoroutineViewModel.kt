package com.jakmos.coroutinesplayground.guide

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineViewModel : ViewModel() {

    fun onCreate() = viewModelScope.launch {
        showLoader()

        println("Books: ${fetchBooks()}")
        println("Authors: ${fetchAuthors()}")

        hideLoader()
    }

    private fun showLoader() {
        println("Loader shown")
    }

    private suspend fun fetchBooks(): List<String> {
        println("Fetching books...")
        delay(3000)

        println("Books fetched!")
        return listOf("Harry Potter", "Lord of the rings", "The Name of the Wind")
    }

    private suspend fun fetchAuthors(): List<String> {
        println("Fetching authors...")
        delay(5000)

        println("Authors fetched!")
        return listOf("J.K. Rowling", "Tolkien", "Patrick Rothfuss")
    }

    private fun hideLoader() {
        println("Loader hidden")
    }
}
