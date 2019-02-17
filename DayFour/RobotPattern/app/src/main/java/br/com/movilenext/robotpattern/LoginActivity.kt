package br.com.movilenext.robotpattern

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.longToast
import org.jetbrains.anko.yesButton

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                showAlert(R.string.missing_fields)
            } else if (email == "admin@admin.com" && password == "admin") {
                tvNameSurname.text = getString(R.string.name_surname)

                longToast("Yay!!")
            } else {
                showAlert(R.string.login_fail)
            }
        }
    }

    private fun showAlert(@StringRes id: Int) {
        alert(id) {
            yesButton { }
        }.show()
    }
}
