package br.com.movilenext.taco.data.mappers

import br.com.movilenext.taco.data.db.food.FoodEntity
import br.com.movilenext.taco.data.ws.food.Food
import dagger.Reusable
import javax.inject.Inject

@Reusable
class FoodDataMapper @Inject constructor() : Mapper<FoodEntity, Food> {
    override fun transform(from: FoodEntity): Food {
        return Food(
                id = from.id,
                name = from.name,
                categoryId = from.categoryId,
                baseUnit = from.baseUnit,
                baseQtd = from.baseQtd,
                vitaminC = from.vitaminC,
                attributes = from.attributes
        )
    }

    override fun toFrom(to: Food): FoodEntity {
        return FoodEntity(
                id = to.id,
                name = to.name,
                categoryId = to.categoryId,
                baseQtd = to.baseQtd,
                baseUnit = to.baseUnit,
                vitaminC = to.vitaminC,
                attributes = to.attributes
        )
    }

}