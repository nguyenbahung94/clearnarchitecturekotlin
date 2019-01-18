package com.example.hungnb.moviesappcleanarchitecture.features.listmovies

import android.content.Context
import com.example.hungnb.moviesappcleanarchitecture.core.exception.Failure
import com.example.hungnb.moviesappcleanarchitecture.core.functional.Either
import com.example.hungnb.moviesappcleanarchitecture.core.interactor.UseCase
import com.example.hungnb.moviesappcleanarchitecture.core.navigation.Navigator
import com.example.hungnb.moviesappcleanarchitecture.features.listmovies.PlayMovie.Params
import javax.inject.Inject

class PlayMovie
@Inject constructor(
    private val context: Context,
    private val navigator: Navigator
) : UseCase<UseCase.None, Params>() {

    override suspend fun run(params: Params): Either<Failure, None> {
        navigator.openVideo(context, params.url)
        return Either.Right(None())
    }

    data class Params(val url: String)
}
