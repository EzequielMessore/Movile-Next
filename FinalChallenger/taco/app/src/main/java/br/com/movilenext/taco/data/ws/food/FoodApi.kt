package br.com.movilenext.taco.data.ws.food

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodApi {
    @GET("api/v1/category/{categoryId}/food")
    fun getFoodByCategory(@Path("categoryId") id: Int): Observable<List<Food>>
}