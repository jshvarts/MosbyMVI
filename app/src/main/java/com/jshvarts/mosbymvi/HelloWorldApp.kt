package com.jshvarts.mosbymvi

import android.app.Application
import timber.log.Timber

class HelloWorldApp : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}

