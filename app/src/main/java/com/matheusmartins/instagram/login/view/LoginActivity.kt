package com.matheusmartins.instagram.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.matheusmartins.instagram.R
import com.matheusmartins.instagram.common.util.TxtWatcher
import com.matheusmartins.instagram.databinding.ActivityLoginBinding
import com.matheusmartins.instagram.login.Login
import com.matheusmartins.instagram.login.presentation.LoginPresenter

class LoginActivity : AppCompatActivity(), Login.View {

    private lateinit var binding: ActivityLoginBinding
    override lateinit var presenter: Login.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = LoginPresenter(this)

        with(binding) {
            loginEditEmail.addTextChangedListener(watcher)
            loginEditEmail.addTextChangedListener(TxtWatcher {
                displayEmailFailure(null)
            })

            loginEditPassword.addTextChangedListener(watcher)
            loginEditPassword.addTextChangedListener(TxtWatcher {
                displayPasswordFailure(null)
            })

            loginBtnEnter.setOnClickListener {
                presenter.login(loginEditEmail.text.toString(), loginEditPassword.text.toString())

                Handler(Looper.getMainLooper()).postDelayed({
                    loginBtnEnter.showProgress(false)
                }, 2000)
            }
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    private val watcher = TxtWatcher {
        binding.loginBtnEnter.isEnabled = binding.loginEditEmail.text.toString().isNotEmpty()
                && binding.loginEditPassword.text.toString().isNotEmpty()

    }

    override fun showProgress(enable: Boolean) {
        binding.loginBtnEnter.showProgress(enable)

    }

    override fun displayEmailFailure(emailError: Int?) {
        binding.loginEditEmailInput.error = emailError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding.loginEditPasswordInput.error = passwordError?.let { getString(it) }
    }

    override fun onUserAuthenticated() {
        // IR PARA TELA PRINCIPAL
    }

    override fun onUserUnauthorized() {
        // MOSTRAR UM ALERTA
    }
}