package com.example.hungnb.moviesappcleanarchitecture.domain

import com.example.hungnb.moviesappcleanarchitecture.datalayer.MoviesApi
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesService
@Inject constructor(retrofit: Retrofit) : MoviesApi {
    private val moviesApi by lazy { retrofit.create(MoviesApi::class.java) }

    override fun movies() = moviesApi.movies()
    override fun movieDetails(movieId: Int) = moviesApi.movieDetails(movieId)
}
