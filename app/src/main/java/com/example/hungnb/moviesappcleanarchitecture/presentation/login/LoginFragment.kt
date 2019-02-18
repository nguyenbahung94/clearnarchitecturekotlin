package com.example.hungnb.moviesappcleanarchitecture.presentation.login

import android.os.Bundle
import com.example.hungnb.moviesappcleanarchitecture.R
import com.example.hungnb.moviesappcleanarchitecture.presentation.base.BaseFragment

class LoginFragment : BaseFragment() {
    override fun layoutId() = R.layout.fragment_login
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onResume() {
        super.onResume()
    }



}
