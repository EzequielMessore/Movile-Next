package br.com.ezequiel.room.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

/**
 * Created by ezequiel.messore on 27/10/18.
 * ezequiel.messore@s2it.com.br
 */

@Entity(tableName = "word_table")
data class Word(@PrimaryKey
                @NonNull
                @ColumnInfo(name = "word")
                val word: String)