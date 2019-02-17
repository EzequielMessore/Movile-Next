package br.com.movilenext.taco.data.ws.category

import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class CategoryServiceTest {
    private lateinit var service: CategoryService
    private lateinit var categoryApi: CategoryApi

    @Before
    fun setUp() {
        categoryApi = Mockito.mock(CategoryApi::class.java)
        service = CategoryService(categoryApi)
    }

    @Test
    fun testSizeListIsEquals9() {
        val listOf = listOf(Category(1, "aee"))
        Mockito.`when`(categoryApi.listCategories()).thenReturn(Observable.just(listOf))

        val test = service.listCategory().test()
        test.awaitTerminalEvent()

        test.assertValue(listOf)
    }

}