package com.example.hungnb.moviesappcleanarchitecture.presentation.login

import android.content.Context
import android.content.Intent
import com.example.hungnb.moviesappcleanarchitecture.presentation.base.BaseActivity

class LoginActivity : BaseActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }

    override fun fragment() = LoginFragment()
}
