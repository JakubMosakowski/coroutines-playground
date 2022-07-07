package com.jakmos.coroutinesplayground.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

internal class SampleService : Service() {

    private var controller: ServiceController? = null

    override fun onCreate() {
        super.onCreate()
        Log.v("KUBA", "Start service")

        controller = ServiceController()
        controller?.onCreate()
    }

    override fun onBind(intent: Intent?): IBinder? =
        null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int =
        START_STICKY

    override fun onDestroy() {
        Log.v("KUBA", "Destroy service")
        controller?.onDestroy()
        super.onDestroy()
    }
}
