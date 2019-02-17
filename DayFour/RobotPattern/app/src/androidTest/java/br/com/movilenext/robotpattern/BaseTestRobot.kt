package br.com.movilenext.robotpattern

import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.anything

open class BaseTestRobot {
    fun fillEditText(resId: Int, text: String) = onView(withId(resId)).perform(
        ViewActions.replaceText(text),
        ViewActions.closeSoftKeyboard()
    )

    fun clickButton(resId: Int) =
        onView((withId(resId))).perform(ViewActions.click())

    fun textView(resId: Int) = onView(withId(resId))

    fun matchText(resId: Int, string: Int) =
        textView(resId).check(ViewAssertions.matches(ViewMatchers.withId(string)))

    fun matchText(viewInteraction: ViewInteraction, text: String) =
        viewInteraction.check(ViewAssertions.matches(ViewMatchers.withText(text)))

    fun matchText(resId: Int, text: String) = matchText(textView(resId), text)

    // Para usos futuros, caso necessário
    fun clickListItem(listRes: Int, position: Int) {
        onData(anything())
            .inAdapterView(allOf(withId(listRes)))
            .atPosition(position).perform(ViewActions.click())
    }
}
