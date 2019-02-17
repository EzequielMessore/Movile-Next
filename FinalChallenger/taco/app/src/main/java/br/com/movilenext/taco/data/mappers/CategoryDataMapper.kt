package br.com.movilenext.taco.data.mappers

import br.com.movilenext.taco.data.db.category.CategoryEntity
import br.com.movilenext.taco.data.ws.category.Category
import dagger.Reusable
import javax.inject.Inject

@Reusable
class CategoryDataMapper @Inject constructor() : Mapper<CategoryEntity, Category> {

    override fun transform(from: CategoryEntity) = Category(from.id, from.name)

    override fun toFrom(to: Category) = CategoryEntity(to.id, to.name)
}