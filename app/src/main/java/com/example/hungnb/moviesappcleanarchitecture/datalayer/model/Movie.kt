package com.example.hungnb.moviesappcleanarchitecture.datalayer.model

import com.example.hungnb.moviesappcleanarchitecture.common.extension.empty


data class Movie(val id: Int, val poster: String) {

    companion object {
        fun empty() = Movie(0, String.empty())
    }
}
