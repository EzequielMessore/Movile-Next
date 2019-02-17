package br.com.movilenext.databinding

import android.databinding.*
import br.com.movilenext.databinding.utils.bindable

/**
 * Created by ezequiel.messore on 10/11/18.
 * ezequiel.messore@s2it.com.br
 */

class Game(val name: String,
           val launchYear: Int,
           val imageUrl: String,
           val rating: Double) : BaseObservable() {

//    @get:Bindable
//    var rating by bindable(rating, BR.rating)
}

/*class Game(
        name: String,
        launchYear: Int,
        imageUrl: String,
        rating: Double
) : BaseObservable() {
    val isClassic = launchYear < 2000

    val name = ObservableField<String>(name)
    val launchYear = ObservableInt(launchYear)
    val imageUrl = ObservableField<String>(imageUrl)
    val rating = ObservableDouble(rating)
}*/
