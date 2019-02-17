package br.com.movilenext.taco.data.db.category

import br.com.movilenext.taco.data.mappers.CategoryDataMapper
import br.com.movilenext.taco.data.ws.category.Category
import br.com.movilenext.taco.domain.datasource.category.CategoryDataSource
import dagger.Reusable
import io.reactivex.Observable
import javax.inject.Inject

@Reusable
class CategoryRepository @Inject constructor(
    private val categoryDao: CategoryDao,
    private val categoryDataMapper: CategoryDataMapper
) : CategoryDataSource {

    override fun listCategory(): Observable<List<Category>> {
        return categoryDao.getAll().toObservable().map { categoryDataMapper.transform(it) }
    }

    fun save(categories: List<Category>): List<Category> {
        categoryDao.insert(*categories.map {
            categoryDataMapper.toFrom(it)
        }.toTypedArray())
        return categories
    }

}