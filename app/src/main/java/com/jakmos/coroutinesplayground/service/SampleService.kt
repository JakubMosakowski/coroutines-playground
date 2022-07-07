package com.jakmos.coroutinesplayground.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

internal class SampleService : Service() {

    lateinit var controller: ServiceController

    override fun onCreate() {
        super.onCreate()
        controller.onCreate()
    }

    override fun onBind(intent: Intent?): IBinder? =
        null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int =
        START_STICKY

    override fun onDestroy() {
        controller.onDestroy()
        super.onDestroy()
    }
}
