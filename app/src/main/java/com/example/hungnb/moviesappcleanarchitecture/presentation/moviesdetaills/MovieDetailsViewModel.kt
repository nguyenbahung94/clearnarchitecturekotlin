package com.example.hungnb.moviesappcleanarchitecture.presentation.moviesdetaills

import android.arch.lifecycle.MutableLiveData
import com.example.hungnb.moviesappcleanarchitecture.datalayer.model.MovieDetails
import com.example.hungnb.moviesappcleanarchitecture.datalayer.model.MovieDetailsView
import com.example.hungnb.moviesappcleanarchitecture.domain.usecases.getDetailMovies.GetMovieDetails
import com.example.hungnb.moviesappcleanarchitecture.domain.usecases.playmovie.PlayMovie
import com.example.hungnb.moviesappcleanarchitecture.presentation.base.BaseViewModel
import javax.inject.Inject

class MovieDetailsViewModel
@Inject constructor(private val getMovieDetails: GetMovieDetails,
                    private val playMovie: PlayMovie
) : BaseViewModel() {

    var movieDetails: MutableLiveData<MovieDetailsView> = MutableLiveData()

    fun loadMovieDetails(movieId: Int) =
            getMovieDetails(GetMovieDetails.Params(movieId)) { it.either(::handleFailure, ::handleMovieDetails) }

    fun playMovie(url: String) = playMovie(PlayMovie.Params(url))

    private fun handleMovieDetails(movie: MovieDetails) {
        this.movieDetails.value = MovieDetailsView(movie.id, movie.title, movie.poster,
                movie.summary, movie.cast, movie.director, movie.year, movie.trailer)
    }
}