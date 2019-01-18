package com.example.hungnb.moviesappcleanarchitecture.features.listmovies

import com.example.hungnb.moviesappcleanarchitecture.core.extension.empty


data class Movie(val id: Int, val poster: String) {

    companion object {
        fun empty() = Movie(0, String.empty())
    }
}
