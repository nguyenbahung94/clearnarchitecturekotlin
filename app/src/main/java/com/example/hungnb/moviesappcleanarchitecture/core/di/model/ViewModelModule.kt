package com.example.hungnb.moviesappcleanarchitecture.core.di.model

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.hungnb.moviesappcleanarchitecture.features.listmovies.MovieDetailsViewModel
import com.example.hungnb.moviesappcleanarchitecture.features.listmovies.MoviesViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindsMoviesViewModel(moviesViewModel: MoviesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailsViewModel::class)
    abstract fun bindsMovieDetailsViewModel(movieDetailsViewModel: MovieDetailsViewModel): ViewModel
}