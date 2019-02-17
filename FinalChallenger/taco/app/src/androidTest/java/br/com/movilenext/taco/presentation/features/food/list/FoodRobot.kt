package br.com.movilenext.taco.presentation.features.food.list

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import br.com.movilenext.taco.R
import br.com.movilenext.taco.base.BaseTestRobot
import br.com.movilenext.taco.base.extensions.getJson
import br.com.movilenext.taco.base.extensions.inject
import br.com.movilenext.taco.base.extensions.jsonToObject
import br.com.movilenext.taco.data.mappers.CategoryModelMapper
import br.com.movilenext.taco.data.ws.category.Category
import okhttp3.mockwebserver.MockWebServer

class FoodRobot(
    private val server: MockWebServer = MockWebServer()
) : BaseTestRobot() {


    private val activityRule = ActivityTestRule(FoodActivity::class.java, false, false)
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    init {
        server.start(36004)
        server.url("/")
    }

    fun destroy() {
        server.shutdown()
    }

    fun start() = apply {
        val category = (context getJson R.raw.category).jsonToObject<Category>()
        val model = CategoryModelMapper().toFrom(category)

        activityRule.launchActivity(FoodActivity.newIntent(context, model))
    }

    fun injectFood200() = apply {
        server.inject(200, context getJson R.raw.foods)
    }


    fun injectUnknownError() = apply {
        server.inject(500, "")
    }

    fun checkItemInRecyclerView(text: String) = apply {
        checkTextIsDisplayedWithDescendant(text, R.id.rv_food)
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