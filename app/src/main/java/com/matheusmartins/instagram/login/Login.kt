package com.matheusmartins.instagram.login

import com.matheusmartins.instagram.common.base.BasePresenter
import com.matheusmartins.instagram.common.base.BaseView

interface Login {

    interface Presenter : BasePresenter {
        fun login(email: String,password: String)

    }

    interface View : BaseView<Presenter> {
        fun showProgress(enable: Boolean)
        fun displayEmailFailure(emailError: Int?)
        fun displayPasswordFailure(passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized()
    }
}