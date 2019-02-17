package br.com.movilenext.taco.domain.interactor

import br.com.movilenext.taco.core.interactor.UseCase.None
import br.com.movilenext.taco.core.interactor.UseCaseObservable
import br.com.movilenext.taco.core.scheduler.ISchedulersProvider
import br.com.movilenext.taco.domain.datasource.category.CategoryProvider
import br.com.movilenext.taco.presentation.features.category.CategoryModel
import javax.inject.Inject

class GetCategories @Inject constructor(
    private val categoryProvider: CategoryProvider,
    schedulerProvider: ISchedulersProvider
) : UseCaseObservable<None?, List<CategoryModel>>(schedulerProvider) {

    override fun buildUseCase(params: None?) = categoryProvider.listCategory()

}