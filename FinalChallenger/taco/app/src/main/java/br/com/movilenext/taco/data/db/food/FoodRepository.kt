package br.com.movilenext.taco.data.db.food

import br.com.movilenext.taco.data.mappers.FoodDataMapper
import br.com.movilenext.taco.data.ws.food.Food
import br.com.movilenext.taco.domain.datasource.food.FoodDataSource
import dagger.Reusable
import io.reactivex.Observable
import javax.inject.Inject

@Reusable
class FoodRepository @Inject constructor(
        private val foodDao: FoodDao,
        private val foodDataMapper: FoodDataMapper
) : FoodDataSource {

    override fun getFoodByCategoryId(id: Int): Observable<List<Food>> {
        return foodDao.getFoodByCategoryId(id).toObservable().map {
            foodDataMapper.transform(it)
        }
    }

}