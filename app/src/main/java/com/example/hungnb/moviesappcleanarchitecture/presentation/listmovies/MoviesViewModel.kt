package com.example.hungnb.moviesappcleanarchitecture.presentation.listmovies

import android.arch.lifecycle.MutableLiveData
import com.example.hungnb.moviesappcleanarchitecture.datalayer.model.Movie
import com.example.hungnb.moviesappcleanarchitecture.datalayer.model.MovieView
import com.example.hungnb.moviesappcleanarchitecture.domain.usecases.UseCase
import com.example.hungnb.moviesappcleanarchitecture.domain.usecases.getMovies.GetMovies
import com.example.hungnb.moviesappcleanarchitecture.presentation.base.BaseViewModel
import javax.inject.Inject

class MoviesViewModel
@Inject constructor(private val getMovies: GetMovies) : BaseViewModel() {

    var movies: MutableLiveData<List<MovieView>> = MutableLiveData()

    fun loadMovies() = getMovies(UseCase.None()) { it.either(::handleFailure, ::handleMovieList) }

    private fun handleMovieList(movies: List<Movie>) {
        this.movies.value = movies.map { MovieView(it.id, it.poster) }
    }
}