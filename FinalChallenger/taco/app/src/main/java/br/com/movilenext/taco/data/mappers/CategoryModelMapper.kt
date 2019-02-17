package br.com.movilenext.taco.data.mappers

import br.com.movilenext.taco.data.ws.category.Category
import br.com.movilenext.taco.presentation.features.category.CategoryModel
import javax.inject.Inject

class CategoryModelMapper @Inject constructor(): Mapper<CategoryModel, Category> {
    override fun transform(from: CategoryModel) = Category(from.id, from.name)

    override fun toFrom(to: Category) = CategoryModel(to.id, to.name)

}