package br.com.movilenext.taco.data.db.category

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryEntity(
    @PrimaryKey
    val id: Int,
    val name: String
)