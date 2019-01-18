
package com.example.hungnb.moviesappcleanarchitecture.features.listmovies

import com.example.hungnb.moviesappcleanarchitecture.core.interactor.UseCase
import com.example.hungnb.moviesappcleanarchitecture.features.listmovies.GetMovieDetails.Params
import javax.inject.Inject

class GetMovieDetails
@Inject constructor(private val moviesRepository: MoviesRepository) : UseCase<MovieDetails, Params>() {

    override suspend fun run(params: Params) = moviesRepository.movieDetails(params.id)

    data class Params(val id: Int)
}
