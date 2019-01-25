package com.example.hungnb.moviesappcleanarchitecture.presentation.login

import android.animation.Animator
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.View.VISIBLE
import com.example.hungnb.moviesappcleanarchitecture.R
import com.example.hungnb.moviesappcleanarchitecture.common.extension.viewModel
import com.example.hungnb.moviesappcleanarchitecture.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment() {
    override fun layoutId() = R.layout.fragment_login
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel=viewModel(viewModelFactory){
        }

    }


    override fun onResume() {
        super.onResume()
        object : CountDownTimer(5000, 1000) {
            override fun onFinish() {
                bookITextView.visibility = View.GONE
                loadingProgressBar.visibility = View.GONE
                rootView.setBackgroundColor(ContextCompat.getColor(context!!, R.color.colorSplashText))
                bookIconImageView.setImageResource(R.drawable.film)
                startAnimation()
            }

            override fun onTick(p0: Long) {}
        }.start()
    }

    private fun startAnimation() {
        bookIconImageView.animate().apply {
            x(50f)
            y(100f)
            duration = 1000
        }.setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
                afterAnimationView.visibility = VISIBLE
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationStart(p0: Animator?) {
            }
        })
    }

}
