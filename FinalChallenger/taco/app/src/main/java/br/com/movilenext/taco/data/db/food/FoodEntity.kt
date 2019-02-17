package br.com.movilenext.taco.data.db.food

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import br.com.movilenext.taco.data.ws.food.FoodAttributes
import br.com.movilenext.taco.data.ws.food.VitaminC

@Entity(tableName = "food")
data class FoodEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    @ColumnInfo(name = "base_qtd")
    val baseQtd: Int,
    @ColumnInfo(name = "base_unit")
    val baseUnit: String,
    val vitaminC: VitaminC?,
    @ColumnInfo(name = "category_id")
    val categoryId: Int,
    val attributes: FoodAttributes?
)

