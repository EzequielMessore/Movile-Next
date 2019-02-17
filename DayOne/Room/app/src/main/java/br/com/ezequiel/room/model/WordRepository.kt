package br.com.ezequiel.room.model

import android.app.Application
import android.arch.lifecycle.LiveData
import org.jetbrains.anko.doAsync

/**
 * Created by ezequiel.messore on 27/10/18.
 * ezequiel.messore@s2it.com.br
 */
class WordRepository(application: Application) {
    private val wordDao: WordDao
    val allWords: LiveData<List<Word>>

    init {
        val db = WordRoomDatabase.getDatabase(application)
        wordDao = db.wordDao()
        allWords = wordDao.getAllWords()
    }

    fun insert(word: Word) {
        doAsync { wordDao.insert(word) }
    }

}