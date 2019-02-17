package br.com.movilenext.taco.data.ws.food

import br.com.movilenext.taco.data.db.food.FoodDao
import br.com.movilenext.taco.data.mappers.FoodDataMapper
import br.com.movilenext.taco.domain.datasource.food.FoodDataSource
import io.reactivex.Observable
import javax.inject.Inject

class FoodService @Inject constructor(
        private val foodApi: FoodApi,
        private val foodDao: FoodDao,
        private val foodDataMapper: FoodDataMapper
) : FoodDataSource {

    override fun getFoodByCategoryId(id: Int): Observable<List<Food>> = foodApi
            .getFoodByCategory(id)
            .map { save(it) }

    private fun save(foods: List<Food>): List<Food> {
        foodDao.insert(*foods.map {
            foodDataMapper.toFrom(it)
        }.toTypedArray())
        return foods
    }
}