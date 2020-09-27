package com.maku.testapp.scope

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.os.IBinder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class ScopedService: Service() , CoroutineScope {
    // Binder given to clients
    private val binder = LocalScopedBinder()
    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main //job will be running on the main thread

    override fun onCreate() {
        super.onCreate()
        job = Job()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    inner class LocalScopedBinder : Binder() {
        // Return this instance of LocalService so clients can call public methods
        fun getService(): ScopedService = this@ScopedService
    }
}