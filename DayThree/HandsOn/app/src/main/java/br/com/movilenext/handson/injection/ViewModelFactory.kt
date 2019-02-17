package br.com.movilenext.handson.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import br.com.movilenext.handson.model.db.AppDatabase
import br.com.movilenext.handson.ui.post.PostListViewModel
import java.lang.IllegalArgumentException

/**
 * Created by ezequiel.messore on 15/11/18.
 * ezequiel.messore@s2it.com.br
 */
class ViewModelFactory(private val activity: AppCompatActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostListViewModel::class.java)) {
            val db = Room
                .databaseBuilder(activity.applicationContext, AppDatabase::class.java, "posts")
                .build()
            @Suppress("UNCHECKED_CAST")
            return PostListViewModel(db.postDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}