package br.com.movilenext.taco.presentation.features.food.list

import android.support.test.filters.MediumTest
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class FoodActivityTest {

    private lateinit var robot: FoodRobot
    private val item = "Arroz, tipo 1, cozido"

    @Before
    fun setUp() {
        robot = FoodRobot()
    }

    @After
    fun tearDown() {
        robot.destroy()
    }

    @Test
    fun shouldBeShowItemInList() {
        robot
            .injectFood200()
            .start()
            .checkItemInRecyclerView(item)
    }

    @Test
    fun shouldBeShowError() {
        robot
            .injectUnknownError()
            .start()
            .checkErrorIsVisible()
    }

    @Test
    fun shouldBeSearchFoodByName() {
        robot
            .injectFood200()
            .start()
            .clickInSearch()
            .setTextInSearch(item)
            .checkItemInRecyclerView(item)
    }
}