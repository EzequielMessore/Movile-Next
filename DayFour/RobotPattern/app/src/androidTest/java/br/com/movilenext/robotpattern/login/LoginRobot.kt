package br.com.movilenext.robotpattern.login

import android.content.Context
import br.com.movilenext.robotpattern.BaseTestRobot
import br.com.movilenext.robotpattern.R

class LoginRobot(private val context: Context) : BaseTestRobot() {
    fun setEmail(email: String) = apply {
        fillEditText(R.id.etEmail, email)
    }

    fun setPassword(pass: String) = apply {
        fillEditText(R.id.etPassword, pass)
    }

    fun clickLogin() = apply {
        clickButton(R.id.btLogin)
    }

    fun matchErrorText(err: Int) = matchText(
            textView(android.R.id.message),
            context.getString(err)
    )

}

