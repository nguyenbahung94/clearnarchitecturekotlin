package com.example.hungnb.moviesappcleanarchitecture.presentation.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.hungnb.moviesappcleanarchitecture.common.exception.Failure

/**
 * Base ViewModel class with default Failure handling.
 * @see ViewModel
 * @see Failure
 */
abstract class BaseViewModel : ViewModel() {

    var failure: MutableLiveData<Failure> = MutableLiveData()
    var isDialogShowing: MutableLiveData<DialogIsShowing> = MutableLiveData();

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }

    protected fun setvalueDialog(dialogIsShowing: DialogIsShowing) {
        isDialogShowing.value = dialogIsShowing
    }

    protected fun getValueDialog(): DialogIsShowing? {
        return isDialogShowing.value
    }
}