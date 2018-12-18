package com.example.billy.exampleandroidcleanarchitecturekotlin

import android.app.Application
import com.squareup.leakcanary.LeakCanary


class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }

    private fun injectMembers() {

    }

    private fun initializeLeakDetection() {
        if (BuildConfig.DEBUG) LeakCanary.install(this)
    }
}