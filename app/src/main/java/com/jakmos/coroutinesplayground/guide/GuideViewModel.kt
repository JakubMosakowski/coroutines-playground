package com.jakmos.coroutinesplayground.guide

import androidx.lifecycle.ViewModel

class GuideViewModel : ViewModel() {

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
        println(fetchBooks())
        hideLoader()
    }

    private fun showLoader() {
        println("Loader shown")
    }

    private fun fetchBooks(): List<String> {
        println("Fetching books...")
        Thread.sleep(10000)
        println(".")
        println(".")
        println(".")
        println("Books fetched!")
        return listOf("Harry Potter", "Lord of the rings", "The Name of the Wind")
    }

    private fun hideLoader() {
        println("Loader hidden")
    }
}
