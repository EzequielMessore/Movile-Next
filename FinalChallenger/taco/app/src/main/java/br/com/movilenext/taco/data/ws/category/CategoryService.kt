package br.com.movilenext.taco.data.ws.category

import br.com.movilenext.taco.domain.datasource.category.CategoryDataSource
import io.reactivex.Observable
import javax.inject.Inject

class CategoryService @Inject constructor(
    private val categoryApi: CategoryApi
) : CategoryDataSource {
    override fun listCategory(): Observable<List<Category>> =
        categoryApi
            .listCategories()
            .flatMapIterable { it }
            .filter { it.id <= 9 }
            .toList()
            .toObservable()
}