package br.com.movilenext.taco.data.ws.food

import com.google.gson.annotations.SerializedName

data class Food(
    val id: Int,

    @SerializedName("description")
    val name: String,

    @SerializedName("base_qty")
    val baseQtd: Int,

    @SerializedName("base_unit")
    val baseUnit: String,

    @SerializedName("vitaminC")
    val vitaminC: VitaminC?,

    @SerializedName("category_id")
    val categoryId: Int,

    val attributes: FoodAttributes?

)

data class VitaminC(val qty: String, val unit: String)