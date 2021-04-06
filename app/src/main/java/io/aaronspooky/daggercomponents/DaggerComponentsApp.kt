package io.aaronspooky.daggercomponents

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DaggerComponentsApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}