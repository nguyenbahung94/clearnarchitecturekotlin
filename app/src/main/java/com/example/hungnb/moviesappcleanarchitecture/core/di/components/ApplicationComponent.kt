package com.example.hungnb.moviesappcleanarchitecture.core.di.components

import com.example.hungnb.moviesappcleanarchitecture.AndroidApplication
import com.example.hungnb.moviesappcleanarchitecture.core.di.model.ApplicationModule
import com.example.hungnb.moviesappcleanarchitecture.core.di.model.ViewModelModule
import com.example.hungnb.moviesappcleanarchitecture.core.navigation.RouteActivity
import com.example.hungnb.moviesappcleanarchitecture.features.listmovies.MovieDetailsFragment
import com.example.hungnb.moviesappcleanarchitecture.features.listmovies.MoviesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
    fun inject(routeActivity: RouteActivity)

    fun inject(moviesFragment: MoviesFragment)
    fun inject(movieDetailsFragment: MovieDetailsFragment)
}
