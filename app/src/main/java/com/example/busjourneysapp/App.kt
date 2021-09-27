package com.example.busjourneysapp

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import timber.log.Timber

class App : Application(){

    companion object{
        var sessionId = ""
        var deviceId = ""
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

}