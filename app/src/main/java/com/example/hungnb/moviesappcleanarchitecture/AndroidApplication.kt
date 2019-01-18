package com.example.hungnb.moviesappcleanarchitecture

import android.app.Application
import com.example.hungnb.moviesappcleanarchitecture.core.di.components.ApplicationComponent
import com.example.hungnb.moviesappcleanarchitecture.core.di.model.ApplicationModule
import com.squareup.leakcanary.LeakCanary

class AndroidApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
        this.initializeLeakDetection()
    }

    private fun injectMembers() = appComponent.inject(this)

    private fun initializeLeakDetection() {
        if (BuildConfig.DEBUG) LeakCanary.install(this)
    }
}
