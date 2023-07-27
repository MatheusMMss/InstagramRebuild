package com.matheusmartins.instagram.login

import androidx.annotation.StringRes
import com.matheusmartins.instagram.common.base.BasePresenter
import com.matheusmartins.instagram.common.base.BaseView

interface Login {

    interface Presenter : BasePresenter {
        fun login(email: String,password: String)

    }

    interface View : BaseView<Presenter> {
        fun showProgress(enable: Boolean)
        fun displayEmailFailure(@StringRes emailError: Int?)
        fun displayPasswordFailure(@StringRes passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message: String)
    }
}