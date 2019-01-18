package com.example.hungnb.moviesappcleanarchitecture.features.listmovies

data class MovieEntity(private val id: Int, private val poster: String) {
    fun toMovie() = Movie(id, poster)
}
