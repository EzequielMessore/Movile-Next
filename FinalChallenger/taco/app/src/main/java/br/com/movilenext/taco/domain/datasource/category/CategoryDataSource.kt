package br.com.movilenext.taco.domain.datasource.category

import br.com.movilenext.taco.data.ws.category.Category
import io.reactivex.Observable

interface CategoryDataSource {
    fun listCategory(): Observable<List<Category>>
}