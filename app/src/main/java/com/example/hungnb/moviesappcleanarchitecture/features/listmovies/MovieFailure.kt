package com.example.hungnb.moviesappcleanarchitecture.features.listmovies

import com.example.hungnb.moviesappcleanarchitecture.core.exception.Failure

class MovieFailure {
    class ListNotAvailable : Failure.FeatureFailure()
    class NonExistentMovie : Failure.FeatureFailure()
}

