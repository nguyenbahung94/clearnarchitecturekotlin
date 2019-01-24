package com.example.hungnb.moviesappcleanarchitecture.presentation.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.hungnb.moviesappcleanarchitecture.R
import com.example.hungnb.moviesappcleanarchitecture.R.layout.activity_layout
import com.example.hungnb.moviesappcleanarchitecture.common.extension.inTransaction
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_layout)
        setSupportActionBar(toolbar)
        addFragment(savedInstanceState)
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(
                R.id.fragmentContainer) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }

    private fun addFragment(savedInstanceState: Bundle?) =
            savedInstanceState ?: supportFragmentManager.inTransaction {
                add(
                        R.id.fragmentContainer, fragment())
            }

    abstract fun fragment(): BaseFragment
}
