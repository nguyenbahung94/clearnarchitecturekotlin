package com.example.hungnb.moviesappcleanarchitecture.di.components

import com.example.hungnb.moviesappcleanarchitecture.AndroidApplication
import com.example.hungnb.moviesappcleanarchitecture.common.navigation.RouteActivity
import com.example.hungnb.moviesappcleanarchitecture.di.model.ApplicationModule
import com.example.hungnb.moviesappcleanarchitecture.di.model.ViewModelModule
import com.example.hungnb.moviesappcleanarchitecture.presentation.listmovies.MoviesFragment
import com.example.hungnb.moviesappcleanarchitecture.presentation.moviesdetaills.MovieDetailsFragment
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
