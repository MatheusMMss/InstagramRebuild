package com.matheusmartins.instagram.register

import androidx.annotation.StringRes
import com.matheusmartins.instagram.common.base.BasePresenter
import com.matheusmartins.instagram.common.base.BaseView

interface RegisterEmail {

    interface Presenter: BasePresenter {
        fun create(email: String)
    }
    interface View: BaseView<Presenter> {
        fun displayEmailFailure(@StringRes emailError: Int?)
    }
}