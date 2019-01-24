package com.example.hungnb.moviesappcleanarchitecture.datalayer

import com.example.hungnb.moviesappcleanarchitecture.datalayer.model.MovieDetailsEntity
import com.example.hungnb.moviesappcleanarchitecture.domain.usecases.getMovies.MovieEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface MoviesApi {
    companion object {
        private const val PARAM_MOVIE_ID = "movieId"
        private const val MOVIES = "movies.json"
        private const val MOVIE_DETAILS = "movie_0{$PARAM_MOVIE_ID}.json"
    }

    @GET(MOVIES)
    fun movies(): Call<List<MovieEntity>>

    @GET(MOVIE_DETAILS)
    fun movieDetails(@Path(PARAM_MOVIE_ID) movieId: Int): Call<MovieDetailsEntity>
}
