package com.example.hungnb.moviesappcleanarchitecture.presentation.login

import android.arch.lifecycle.MutableLiveData
import com.example.hungnb.moviesappcleanarchitecture.presentation.base.BaseViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor() : BaseViewModel() {
    var checkUser: MutableLiveData<String> = MutableLiveData()
    fun validateInput(email: String, password: String) {

    }
}