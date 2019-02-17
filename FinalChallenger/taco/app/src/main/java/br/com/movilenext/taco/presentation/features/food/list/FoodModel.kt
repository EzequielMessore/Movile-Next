package br.com.movilenext.taco.presentation.features.food.list

import android.os.Parcelable
import br.com.movilenext.taco.core.extension.toFormat
import kotlinx.android.parcel.Parcelize

@Parcelize
class FoodModel(
        val name: String,
        val baseInfo: String,
        val vitaminC: String,
        val categoryId: Int,
        val attributes: FoodAttributesModel
) : Parcelable

@Parcelize
class FoodAttributesModel(
        val carbohydrate: AttributeModel?,
        val sodium: AttributeModel?,
        val energy: EnergyModel?,
        val cholesterol: AttributeModel?,
        val iron: AttributeModel?
) : Parcelable

@Parcelize
data class AttributeModel(
        private val qty: String,
        private val unit: String,
        val color: String,
        val name: String
) : Parcelable {
    val data: String
        get() {
            return qty.toFormat() + unit
        }

    fun isNA() = qty == "NA"
    fun isTR() = qty == "Tr"
}

@Parcelize
data class EnergyModel(val kj: String, val kcal: String, val name: String = "Energia") : Parcelable