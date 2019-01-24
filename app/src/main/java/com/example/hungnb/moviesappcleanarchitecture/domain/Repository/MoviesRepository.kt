package com.example.hungnb.moviesappcleanarchitecture.domain.Repository

import com.example.hungnb.moviesappcleanarchitecture.common.exception.Failure
import com.example.hungnb.moviesappcleanarchitecture.common.functional.Either
import com.example.hungnb.moviesappcleanarchitecture.datalayer.model.Movie
import com.example.hungnb.moviesappcleanarchitecture.datalayer.model.MovieDetails

interface MoviesRepository {
    fun movies(): Either<Failure, List<Movie>>
    fun movieDetails(movieId: Int): Either<Failure, MovieDetails>
}