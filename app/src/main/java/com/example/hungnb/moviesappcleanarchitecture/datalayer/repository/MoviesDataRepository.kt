package com.example.hungnb.moviesappcleanarchitecture.datalayer.repository

import com.example.hungnb.moviesappcleanarchitecture.common.exception.Failure
import com.example.hungnb.moviesappcleanarchitecture.common.functional.Either
import com.example.hungnb.moviesappcleanarchitecture.common.platform.NetworkHandler
import com.example.hungnb.moviesappcleanarchitecture.datalayer.model.Movie
import com.example.hungnb.moviesappcleanarchitecture.datalayer.model.MovieDetails
import com.example.hungnb.moviesappcleanarchitecture.datalayer.model.MovieDetailsEntity
import com.example.hungnb.moviesappcleanarchitecture.domain.Repository.MoviesRepository
import com.example.hungnb.moviesappcleanarchitecture.domain.MoviesService
import retrofit2.Call
import javax.inject.Inject

class MoviesDataRepository
@Inject constructor(private val networkHandler: NetworkHandler,
                    private val service: MoviesService
) : MoviesRepository {

    override fun movies(): Either<Failure, List<Movie>> {
        return when (networkHandler.isConnected) {
            true -> request(service.movies(), { it.map { it.toMovie() } }, emptyList())
            false, null -> Either.Left(Failure.NetworkConnection)
        }
    }

    override fun movieDetails(movieId: Int): Either<Failure, MovieDetails> {
        return when (networkHandler.isConnected) {
            true -> request(service.movieDetails(movieId), { it.toMovieDetails() }, MovieDetailsEntity.empty())
            false, null -> Either.Left(Failure.NetworkConnection)
        }
    }

    private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> Either.Right(transform((response.body() ?: default)))
                false -> Either.Left(Failure.ServerError)
            }
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError)
        }
    }
}