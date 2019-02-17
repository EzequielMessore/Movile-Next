package br.com.movilenext.taco.domain.datasource.food

import br.com.movilenext.taco.data.db.food.FoodRepository
import br.com.movilenext.taco.data.mappers.FoodModelMapper
import br.com.movilenext.taco.data.ws.food.FoodService
import br.com.movilenext.taco.presentation.features.food.list.FoodModel
import dagger.Lazy
import io.reactivex.Observable
import javax.inject.Inject

class FoodProvider @Inject constructor(
        private val foodService: Lazy<FoodService>,
        private val foodModelMapper: FoodModelMapper,
        private val repository: Lazy<FoodRepository>
) {
    fun getFoodByCategoryId(id: Int): Observable<List<FoodModel>> =
            repository
                    .get()
                    .getFoodByCategoryId(id)
                    .flatMap {
                        if (it.isEmpty()) {
                            foodService.get().getFoodByCategoryId(id).map { list ->
                                foodModelMapper.toFrom(list)
                            }
                        } else {
                            Observable.just(foodModelMapper.toFrom(it))
                        }
                    }


}