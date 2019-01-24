package com.example.hungnb.moviesappcleanarchitecture.presentation.listmovies

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.example.hungnb.moviesappcleanarchitecture.R
import com.example.hungnb.moviesappcleanarchitecture.common.exception.Failure
import com.example.hungnb.moviesappcleanarchitecture.common.exception.MovieFailure.ListNotAvailable
import com.example.hungnb.moviesappcleanarchitecture.common.extension.*
import com.example.hungnb.moviesappcleanarchitecture.common.navigation.Navigator
import com.example.hungnb.moviesappcleanarchitecture.datalayer.model.MovieView
import com.example.hungnb.moviesappcleanarchitecture.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject

class MoviesFragment : BaseFragment() {

    @Inject lateinit var navigator: Navigator
    @Inject lateinit var moviesAdapter: MoviesAdapter

    private lateinit var moviesViewModel: MoviesViewModel

    override fun layoutId() = R.layout.fragment_movies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        moviesViewModel = viewModel(viewModelFactory) {
            observe(movies, ::renderMoviesList)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        loadMoviesList()
    }


    private fun initializeView() {
        movieList.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        movieList.adapter = moviesAdapter
        moviesAdapter.clickListener = { movie, navigationExtras ->
                    navigator.showMovieDetails(activity!!, movie, navigationExtras) }
    }

    private fun loadMoviesList() {
        emptyView.invisible()
        movieList.visible()
        showProgress()
        moviesViewModel.loadMovies()
    }

    private fun renderMoviesList(movies: List<MovieView>?) {
        moviesAdapter.collection = movies.orEmpty()
        hideProgress()
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> renderFailure(R.string.failure_network_connection)
            is Failure.ServerError -> renderFailure(R.string.failure_server_error)
            is ListNotAvailable -> renderFailure(R.string.failure_movies_list_unavailable)
        }
    }

    private fun renderFailure(@StringRes message: Int) {
        movieList.invisible()
        emptyView.visible()
        hideProgress()
        notifyWithAction(message, R.string.action_refresh, ::loadMoviesList)
    }
}
