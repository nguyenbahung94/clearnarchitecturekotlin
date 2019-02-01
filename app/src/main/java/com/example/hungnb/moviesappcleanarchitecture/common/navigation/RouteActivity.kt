package com.example.hungnb.moviesappcleanarchitecture.common.navigation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.hungnb.moviesappcleanarchitecture.AndroidApplication
import com.example.hungnb.moviesappcleanarchitecture.di.components.ApplicationComponent
import javax.inject.Inject

class RouteActivity : AppCompatActivity() {

    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        AndroidApplication().appComponent
    }

    @Inject
    internal lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        navigator.showMain(this)
    }
}