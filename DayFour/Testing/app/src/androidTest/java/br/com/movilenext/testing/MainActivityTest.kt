package br.com.movilenext.testing

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withHint
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.filters.MediumTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.TextView
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)
    lateinit var activity: MainActivity

    @Before
    fun setUp() {
        activity = rule.activity
    }

    @Test
    fun loadActivity_shouldShowHelloWord() {
        val viewById = activity.findViewById<TextView>(R.id.textView)

        assertThat(viewById, notNullValue())
        assertThat(viewById.text.toString(), equalTo("Hello World!"))
    }

    @Test
    fun sendButton_shouldWriteHelloName() {
        val name = "Ezequiel Messore"
        onView(withHint("Type your name")).perform(typeText(name))

        onView(withText("Send")).perform(click())
        onView(withText("Hello, $name")).check(matches(isDisplayed()))
    }
}