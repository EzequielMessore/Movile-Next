package br.com.movilenext.databinding.utils

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by ezequiel.messore on 10/11/18.
 * ezequiel.messore@s2it.com.br
 */
object BindingAdapters {

    @JvmStatic
    @BindingAdapter("image")
    fun loadImage(imageView: ImageView, imageUrl: String?) {
        Glide
            .with(imageView.context)
            .load(imageUrl)
            .into(imageView)
    }

}
