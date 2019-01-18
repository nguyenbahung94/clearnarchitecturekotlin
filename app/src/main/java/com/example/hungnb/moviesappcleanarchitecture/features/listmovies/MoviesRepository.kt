package com.example.hungnb.moviesappcleanarchitecture.features.listmovies

import com.example.hungnb.moviesappcleanarchitecture.core.exception.Failure
import com.example.hungnb.moviesappcleanarchitecture.core.functional.Either
import com.example.hungnb.moviesappcleanarchitecture.core.platform.NetworkHandler
import retrofit2.Call
import javax.inject.Inject

interface MoviesRepository {
    fun movies(): Either<Failure, List<Movie>>
    fun movieDetails(movieId: Int): Either<Failure, MovieDetails>

    class Network
    @Inject constructor(private val networkHandler: NetworkHandler,
                        private val service: MoviesService
    ) : MoviesRepository {

        override fun movies(): Either<Failure, List<Movie>> {
            return when (networkHandler.isConnected) {
                true -> request(service.movies(), { it.map { it.toMovie() } }, emptyList())
                false, null -> Left(NetworkConnection)
            }
        }

        override fun movieDetails(movieId: Int): Either<Failure, MovieDetails> {
            return when (networkHandler.isConnected) {
                true -> request(service.movieDetails(movieId), { it.toMovieDetails() }, MovieDetailsEntity.empty())
                false, null -> Left(NetworkConnection)
            }
        }

        private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Right(transform((response.body() ?: default)))
                    false -> Left(ServerError)
                }
            } catch (exception: Throwable) {
                Left(ServerError)
            }
        }
    }
}
