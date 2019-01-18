package com.example.hungnb.moviesappcleanarchitecture.features.listmovies

import android.arch.lifecycle.MutableLiveData
import com.example.hungnb.moviesappcleanarchitecture.core.interactor.UseCase
import com.example.hungnb.moviesappcleanarchitecture.core.platform.BaseViewModel
import javax.inject.Inject

class MoviesViewModel
@Inject constructor(private val getMovies: GetMovies) : BaseViewModel() {

    var movies: MutableLiveData<List<MovieView>> = MutableLiveData()

    fun loadMovies() = getMovies(UseCase.None()) { it.either(::handleFailure, ::handleMovieList) }

    private fun handleMovieList(movies: List<Movie>) {
        this.movies.value = movies.map { MovieView(it.id, it.poster) }
    }
}