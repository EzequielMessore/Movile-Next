package br.com.ezequiel.room.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import br.com.ezequiel.room.model.Word
import br.com.ezequiel.room.model.WordRepository

/**
 * Created by ezequiel.messore on 27/10/18.
 * ezequiel.messore@s2it.com.br
 */
class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = WordRepository(application)
    val allWords = repository.allWords

    fun insert(word: Word) {
        repository.insert(word)
    }
}