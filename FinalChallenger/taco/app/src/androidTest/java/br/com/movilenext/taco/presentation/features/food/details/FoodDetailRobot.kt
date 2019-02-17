package br.com.movilenext.taco.presentation.features.food.details

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import br.com.movilenext.taco.R
import br.com.movilenext.taco.base.BaseTestRobot
import br.com.movilenext.taco.base.extensions.getJson
import br.com.movilenext.taco.base.extensions.jsonToObject
import br.com.movilenext.taco.data.mappers.FoodModelMapper
import br.com.movilenext.taco.data.ws.food.Food
import okhttp3.mockwebserver.MockWebServer

class FoodDetailRobot(
    private val server: MockWebServer = MockWebServer()
) : BaseTestRobot() {

    private val activityRule = ActivityTestRule(FoodDetailActivity::class.java, false, false)
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    init {
        server.start(36004)
        server.url("/")
    }

    fun destroy() {
        server.shutdown()
    }

    fun startComplete() = apply {
        val food = (context getJson R.raw.food).jsonToObject<Food>()
        start(food)
    }

    fun startIncomplete() = apply {
        val food = (context getJson R.raw.food_incomplete).jsonToObject<Food>()
        start(food)
    }

    private fun start(food: Food) {
        val model = FoodModelMapper().toFrom(food)

        activityRule.launchActivity(FoodDetailActivity.newIntent(context, model))
    }

    fun checkIfShowingEnergy() = apply {
        checkTextIsVisible("Energia")
        checkTextIsVisible("123.53kcal")
        checkTextIsVisible("516.87kj")
    }

    fun checkIfShowingCarbohydrate() = apply {
        checkTextIsVisible("Carboidrato")
        checkTextIsVisible("25.81g")
    }

    fun checkIfShowingCholesterol() = apply {
        checkTextIsVisible("Colesterol")
        checkTextIsVisible("23.21mg")
    }

    fun checkIfShowingSodium() = apply {
        checkTextIsVisible("Sódio")
        checkTextIsVisible("1.24mg")
    }

    fun checkIfShowingIron() = apply {
        checkTextIsVisible("Ferro")
        checkTextIsVisible("0.26mg")
    }

    fun checkName(text: String) = apply {
        matchText(R.id.tv_name, text)
    }

    fun checkIfNotShowingCholesterol() = apply {
        Thread.sleep(3000)
        checkTextIsNotDisplayed("Colesterol")
    }


}