package br.com.movilenext.handson.model.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.movilenext.handson.model.Post

/**
 * Created by ezequiel.messore on 15/11/18.
 * ezequiel.messore@s2it.com.br
 */
@Database(entities = [(Post::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}