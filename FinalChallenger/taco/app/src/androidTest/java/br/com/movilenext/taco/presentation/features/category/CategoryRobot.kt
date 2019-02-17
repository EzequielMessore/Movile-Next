package br.com.movilenext.taco.presentation.features.category

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import br.com.movilenext.taco.R
import br.com.movilenext.taco.base.BaseTestRobot
import br.com.movilenext.taco.base.extensions.getJson
import br.com.movilenext.taco.base.extensions.inject
import okhttp3.mockwebserver.MockWebServer

class CategoryRobot(
    private val server: MockWebServer = MockWebServer()
) : BaseTestRobot() {


    private val activityRule = ActivityTestRule(CategoryActivity::class.java, false, false)
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    init {
        server.start(36004)
        server.url("/")
    }

    fun destroy() {
        server.shutdown()
    }

    fun start() = apply {
        activityRule.launchActivity(Intent())
    }

    fun injectCategories200() = apply {
        server.inject(200, context getJson R.raw.categories)
    }

    fun injectCategories500() = apply {
        server.inject(500, context getJson R.raw.categories_empty)
    }

    fun checkItemInRecyclerView(text: String) = apply {
        checkTextIsDisplayedWithDescendant(text, R.id.rv_category)
    }

    fun checkErrorIsVisible() = apply {
        checkIdIsVisible(R.id.iv_error)
        checkIdIsVisible(R.id.tv_title)
        checkIdIsVisible(R.id.btn_try_again)
    }

    fun clickInSearch() = apply {
        clickView(R.id.menuSearch)
    }

    fun setTextInSearch(text: String) = apply {
        setTextInSearchView(text)
    }


}