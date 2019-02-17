package br.com.movilenext.taco.data.ws.category

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id")
    val id: Int,
    @SerializedName("category")
    val name: String
)