package com.jakmos.coroutinesplayground.guide

import androidx.lifecycle.ViewModel

class IdealViewModel : ViewModel() {

    /**
     * What for:
     *  1. Downloading the data (from API or database) - what is API?
     *  2. Data processing (mapping?)
     *  3. Data transfer (to API or database).
     *  4. Long-running operations (asynchronously) - what does it mean asynchronously?
     *  5. Concurrency - what is concurrent programming?
     */

    fun onCreate() {
        showLoader()

        println("Books: ${fetchBooks()}")
        println("Authors: ${fetchAuthors()}")

        hideLoader()
    }

    private fun showLoader() {
        println("Loader shown")
    }

    private fun fetchBooks(): List<String> {
        println("Fetching books...")

        println("Books fetched!")
        return listOf("Harry Potter", "Lord of the rings", "The Name of the Wind")
    }

    private fun fetchAuthors(): List<String> {
        println("Fetching authors...")

        println("Authors fetched!")
        return listOf("J.K. Rowling", "Tolkien", "Patrick Rothfuss")
    }

    private fun hideLoader() {
        println("Loader hidden")
    }
}
