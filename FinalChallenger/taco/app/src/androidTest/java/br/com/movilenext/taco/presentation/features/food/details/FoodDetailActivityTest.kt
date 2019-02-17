package br.com.movilenext.taco.presentation.features.food.details

import android.support.test.filters.MediumTest
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class FoodDetailActivityTest {

    private lateinit var robot: FoodDetailRobot

    @Before
    fun setUp() {
        robot = FoodDetailRobot()
    }

    @After
    fun tearDown() {
        robot.destroy()
    }

    @Test
    fun shouldBeShowCompleteFood() {
        robot
            .startComplete()
            .checkIfShowingEnergy()
            .checkIfShowingCholesterol()
            .checkIfShowingCarbohydrate()
            .checkIfShowingSodium()
            .checkIfShowingIron()
            .checkName("Arroz, integral, cozido")
    }

    @Test
    fun shouldNotShowCholesterolView() {
        robot
            .startIncomplete()
            .checkIfShowingEnergy()
            .checkIfShowingCarbohydrate()
            .checkIfShowingSodium()
            .checkIfShowingIron()
            .checkIfNotShowingCholesterol()
            .checkName("Arroz, integral, cozido")
    }
}