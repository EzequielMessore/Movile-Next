package br.com.movilenext.taco.presentation.features.category

import android.support.test.filters.MediumTest
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class CategoryActivityTest {

    private lateinit var robot: CategoryRobot
    private val firstItem = "Cereais e derivados"

    @Before
    fun setUp() {
        robot = CategoryRobot()
    }

    @After
    fun tearDown() {
        robot.destroy()
    }

    @Test
    fun shouldBeShowItemInList() {
        robot
            .injectCategories200()
            .start()
            .checkItemInRecyclerView(firstItem)
    }

    @Test
    fun shouldBeShowContainerError() {
        robot
            .injectCategories500()
            .start()
            .checkErrorIsVisible()
    }

    @Test
    fun shouldBeSearchCategoryByName() {
        robot
            .injectCategories200()
            .start()
            .clickInSearch()
            .setTextInSearch(firstItem)
            .checkItemInRecyclerView(firstItem)
    }

}