package br.com.movilenext.taco.presentation.features.category

import android.os.Parcelable
import br.com.movilenext.taco.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryModel(val id: Int, val name: String) : Parcelable {

    fun getImage(): Int =
        when (id) {
            1 -> R.drawable.cereals
            2 -> R.drawable.vegetable
            3 -> R.drawable.fruits
            4 -> R.drawable.oil
            5 -> R.drawable.fish
            6 -> R.drawable.beef
            7 -> R.drawable.milk
            8 -> R.drawable.drink
            9 -> R.drawable.egg
            else -> R.drawable.cereals
        }
}