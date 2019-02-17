package br.com.movilenext.taco.data.db.converters

import android.arch.persistence.room.TypeConverter
import br.com.movilenext.taco.data.ws.food.FoodAttributes
import br.com.movilenext.taco.data.ws.food.VitaminC
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun vitaminFromJson(model: VitaminC?): String {
        return Gson().toJson(model)
    }

    @TypeConverter
    fun jsonToVitamin(json: String): VitaminC? {
        return Gson().fromJson<VitaminC?>(json, VitaminC::class.java)
    }

    @TypeConverter
    fun attributeFromJson(model: FoodAttributes): String {
        return Gson().toJson(model)
    }

    @TypeConverter
    fun jsonToAttribute(json: String): FoodAttributes {
        return Gson().fromJson(json, FoodAttributes::class.java)
    }

}