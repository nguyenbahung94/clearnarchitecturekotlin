package com.example.hungnb.moviesappcleanarchitecture.features.listmovies

import android.content.Context
import android.content.Intent
import com.example.hungnb.moviesappcleanarchitecture.core.platform.BaseActivity

class MoviesActivity : BaseActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, MoviesActivity::class.java)
    }

    override fun fragment() = MoviesFragment()
}
