package br.com.movilenext.handson.model.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import br.com.movilenext.handson.model.Post

/**
 * Created by ezequiel.messore on 15/11/18.
 * ezequiel.messore@s2it.com.br
 */
@Dao
interface PostDao {
    @get:Query("SELECT * FROM post")
    val all: List<Post>

    @Insert
    fun insertAll(vararg posts: Post)
}