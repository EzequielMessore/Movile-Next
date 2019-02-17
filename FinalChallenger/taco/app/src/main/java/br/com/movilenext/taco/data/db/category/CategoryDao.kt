package br.com.movilenext.taco.data.db.category

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
abstract class CategoryDao {
    @Query("SELECT * FROM category")
    abstract fun getAll(): Flowable<List<CategoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg categories: CategoryEntity)

}