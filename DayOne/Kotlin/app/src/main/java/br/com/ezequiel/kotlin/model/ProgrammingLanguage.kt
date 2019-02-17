package br.com.ezequiel.kotlin.model

import android.support.annotation.DrawableRes

/**
 * Created by ezequiel.messore on 27/10/18.
 * ezequiel.messore@s2it.com.br
 */
data class ProgrammingLanguage(
        @DrawableRes val imageResourceId: Int,
        val title: String,
        val year: Int,
        val description: String
)