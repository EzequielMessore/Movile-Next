package br.com.movilenext.testing

import android.widget.TextView
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric.setupActivity
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainActivityRobolectricTest {

    @Test
    fun loadActivity_shouldShowHelloWord() {
        val activity = setupActivity(MainActivity::class.java)

        val viewById = activity.findViewById<TextView>(R.id.textView)

        assertThat(viewById, notNullValue())
        assertThat(viewById.text.toString(), equalTo("Hello World!"))
    }

    @Test
    fun loadActivity_shouldShowHelloWord2() {
        val activity = setupActivity(MainActivity::class.java)

        val viewById = activity.findViewById<TextView>(R.id.textView)

        assertThat(viewById, notNullValue())
        assertThat(viewById.text.toString(), equalTo("Hello World!"))
    }
}
