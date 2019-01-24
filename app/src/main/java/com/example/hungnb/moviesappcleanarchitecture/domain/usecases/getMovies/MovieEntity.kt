package com.example.hungnb.moviesappcleanarchitecture.domain.usecases.getMovies

import com.example.hungnb.moviesappcleanarchitecture.datalayer.model.Movie

data class MovieEntity(private val id: Int, private val poster: String) {
    fun toMovie() = Movie(id, poster)
}
