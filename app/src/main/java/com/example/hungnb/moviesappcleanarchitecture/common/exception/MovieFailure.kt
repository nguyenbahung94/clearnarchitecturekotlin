package com.example.hungnb.moviesappcleanarchitecture.common.exception

class MovieFailure {
    class ListNotAvailable : Failure.FeatureFailure()
    class NonExistentMovie : Failure.FeatureFailure()
}

