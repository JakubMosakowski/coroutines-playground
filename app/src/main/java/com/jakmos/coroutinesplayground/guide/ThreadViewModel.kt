package com.jakmos.coroutinesplayground.guide

import androidx.lifecycle.ViewModel
import kotlin.concurrent.thread

class ThreadViewModel : ViewModel() {

    fun onCreate() {
//        thread {
            showLoader()

            println("Books: ${fetchBooks()}")
            println("Authors: ${fetchAuthors()}")

            hideLoader()
//        }
    }

    private fun showLoader() {
        println("Loader shown")
    }

    private fun fetchBooks(): List<String> {
        println("Fetching books...")
        Thread.sleep(5000)

        println("Books fetched!")
        return listOf("Harry Potter", "Lord of the rings", "The Name of the Wind")
    }

    private fun fetchAuthors(): List<String> {
        println("Fetching authors...")
        Thread.sleep(3000)

        println("Authors fetched!")
        return listOf("J.K. Rowling", "Tolkien", "Patrick Rothfuss")
    }

    private fun hideLoader() {
        println("Loader hidden")
    }
}
