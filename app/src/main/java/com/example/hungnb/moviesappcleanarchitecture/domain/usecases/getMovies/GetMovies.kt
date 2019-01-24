package com.example.hungnb.moviesappcleanarchitecture.domain.usecases.getMovies

import com.example.hungnb.moviesappcleanarchitecture.domain.usecases.UseCase
import com.example.hungnb.moviesappcleanarchitecture.datalayer.model.Movie
import com.example.hungnb.moviesappcleanarchitecture.domain.Repository.MoviesRepository
import javax.inject.Inject

class GetMovies
@Inject constructor(private val moviesRepository: MoviesRepository) : UseCase<List<Movie>, UseCase.None>() {

    override suspend fun run(params: None) = moviesRepository.movies()
}
