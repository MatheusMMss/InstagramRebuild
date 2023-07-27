package com.matheusmartins.instagram.common.base

import com.matheusmartins.instagram.login.data.FakeDataSource
import com.matheusmartins.instagram.login.data.LoginRepository

object DependencyInjector {
    fun loginRepository() : LoginRepository {
        return LoginRepository(FakeDataSource())
    }
}