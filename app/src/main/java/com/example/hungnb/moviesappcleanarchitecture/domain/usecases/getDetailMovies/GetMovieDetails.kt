
package com.example.hungnb.moviesappcleanarchitecture.domain.usecases.getDetailMovies

import com.example.hungnb.moviesappcleanarchitecture.datalayer.model.MovieDetails
import com.example.hungnb.moviesappcleanarchitecture.domain.Repository.MoviesRepository
import com.example.hungnb.moviesappcleanarchitecture.domain.usecases.UseCase
import com.example.hungnb.moviesappcleanarchitecture.domain.usecases.getDetailMovies.GetMovieDetails.Params
import javax.inject.Inject

class GetMovieDetails
@Inject constructor(private val moviesRepository: MoviesRepository) : UseCase<MovieDetails, Params>() {

    override suspend fun run(params: Params) = moviesRepository.movieDetails(params.id)

    data class Params(val id: Int)
}
