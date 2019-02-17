package br.com.movilenext.taco.data.ws.food


data class FoodAttributes(
    val carbohydrate: Attribute?,
    val sodium: Attribute?,
    val energy: Energy?,
    val cholesterol: Attribute?,
    val iron: Attribute?
)

open class Attribute(
    val qty: String,
    val unit: String
)

class Energy(
    val kcal: Double,
    val kj: Double
)