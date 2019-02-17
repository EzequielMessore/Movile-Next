package br.com.movilenext.handson.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by ezequiel.messore on 12/11/18.
 * ezequiel.messore@s2it.com.br
 */
@Entity
data class Post(
    val userId: Int,
    @field:PrimaryKey
    val id: Int,
    val title: String,
    val body: String
)