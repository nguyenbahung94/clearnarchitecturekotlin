package com.example.hungnb.moviesappcleanarchitecture.features.listmovies

import com.example.hungnb.moviesappcleanarchitecture.core.interactor.UseCase
import javax.inject.Inject

class GetMovies
@Inject constructor(private val moviesRepository: MoviesRepository) : UseCase<List<Movie>, UseCase.None>() {

    override suspend fun run(params: None) = moviesRepository.movies()
}
