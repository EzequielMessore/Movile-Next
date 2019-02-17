package br.com.movilenext.taco.presentation.features.food.list

import android.arch.lifecycle.MutableLiveData
import br.com.movilenext.taco.core.platform.BaseViewModel
import br.com.movilenext.taco.domain.interactor.GetFoodByCategoryId
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class FoodViewModel @Inject constructor(
        private val getFoodByCategoryId: GetFoodByCategoryId
) : BaseViewModel() {

    val state: MutableLiveData<FoodState> = MutableLiveData()
    var categoryImage: Int? = null

    private var foods: List<FoodModel> = emptyList()

    fun loadFoodsByCategory(categoryId: Int) {
        state.value = FoodLoading
        getFoodByCategoryId(categoryId)
                .subscribeBy(
                        onNext = {
                            foods = it
                            state.value = FoodData(it)
                        },
                        onError = {
                            println(it.printStackTrace())
                            state.value = FoodError(it)
                        }
                ).addTo(disposable)
    }

    fun filterCategories(query: String) {
        val list = filter(query, foods) {
            it.name.toLowerCase().contains(query.toLowerCase())
        }
        state.value = FoodData(list)
    }


}