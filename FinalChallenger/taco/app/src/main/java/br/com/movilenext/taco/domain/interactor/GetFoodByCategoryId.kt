package br.com.movilenext.taco.domain.interactor

import br.com.movilenext.taco.core.interactor.UseCaseObservable
import br.com.movilenext.taco.core.scheduler.SchedulersProvider
import br.com.movilenext.taco.domain.datasource.food.FoodProvider
import br.com.movilenext.taco.presentation.features.food.list.FoodModel
import javax.inject.Inject

class GetFoodByCategoryId @Inject constructor(
    private val foodProvider: FoodProvider,
    schedulersProvider: SchedulersProvider
) : UseCaseObservable<Int, List<FoodModel>>(schedulersProvider) {

    override fun buildUseCase(params: Int)
            = foodProvider.getFoodByCategoryId(params)
}