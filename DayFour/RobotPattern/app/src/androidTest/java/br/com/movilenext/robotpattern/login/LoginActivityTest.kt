package br.com.movilenext.robotpattern.login

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import br.com.movilenext.robotpattern.LoginActivity
import br.com.movilenext.robotpattern.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val rule = ActivityTestRule(LoginActivity::class.java)

    private lateinit var robot: LoginRobot

    @Before
    fun setUp() {
        robot = LoginRobot(rule.activity)
    }

    @Test
    fun loginSuccess() {
        robot
            .setEmail("admin@admin.com")
            .setPassword("admin")
            .clickLogin()
            .matchText(R.id.tvNameSurname, R.string.name_surname)
    }

    @Test
    fun loginMissingEmailPassword() {
        robot
            .clickLogin()
            .matchErrorText(R.string.missing_fields)
    }

    @Test
    fun loginMissingPassword() {
        robot
            .setEmail("admin@admin.com")
            .clickLogin()
            .matchErrorText(R.string.missing_fields)
    }

    @Test
    fun loginWrongPassword() {
        robot
            .setEmail("admin@admin.com")
            .setPassword("123")
            .clickLogin()
            .matchErrorText(R.string.login_fail)
    }
}