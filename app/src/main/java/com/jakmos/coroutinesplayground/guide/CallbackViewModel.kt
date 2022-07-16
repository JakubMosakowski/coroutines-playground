package com.jakmos.coroutinesplayground.guide

import androidx.lifecycle.ViewModel

class CallbackViewModel : ViewModel() {

    fun onCreate() {
        showLoader()
        fetchBooks { books ->
            fetchAuthors { authors ->
                println("Books: $books")
                println("Authors: $authors")
                hideLoader()
            }
        }
    }

    private fun showLoader() {
        println("Loader shown")
    }

    private fun fetchBooks(onSuccess: (List<String>) -> Unit) {
        println("Fetching books...")

        println("Books fetched!")
        onSuccess(listOf("Harry Potter", "Lord of the rings", "The Name of the Wind"))
    }

    private fun fetchAuthors(onSuccess: (List<String>) -> Unit) {
        println("Fetching authors...")

        println("Authors fetched!")
        onSuccess(listOf("J.K. Rowling", "Tolkien", "Patrick Rothfuss"))
    }

    private fun hideLoader() {
        println("Loader hidden")
    }
}
