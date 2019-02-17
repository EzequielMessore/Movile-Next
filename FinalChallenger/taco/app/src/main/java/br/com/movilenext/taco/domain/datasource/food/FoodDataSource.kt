package br.com.movilenext.taco.domain.datasource.food

import br.com.movilenext.taco.data.ws.food.Food
import io.reactivex.Observable

interface FoodDataSource {
    fun getFoodByCategoryId(id: Int): Observable<List<Food>>
}