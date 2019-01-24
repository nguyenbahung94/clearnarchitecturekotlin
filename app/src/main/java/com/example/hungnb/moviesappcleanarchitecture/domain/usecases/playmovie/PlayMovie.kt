package com.example.hungnb.moviesappcleanarchitecture.domain.usecases.playmovie

import android.content.Context
import com.example.hungnb.moviesappcleanarchitecture.common.exception.Failure
import com.example.hungnb.moviesappcleanarchitecture.common.functional.Either
import com.example.hungnb.moviesappcleanarchitecture.common.navigation.Navigator
import com.example.hungnb.moviesappcleanarchitecture.domain.usecases.UseCase
import com.example.hungnb.moviesappcleanarchitecture.domain.usecases.playmovie.PlayMovie.Params
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
