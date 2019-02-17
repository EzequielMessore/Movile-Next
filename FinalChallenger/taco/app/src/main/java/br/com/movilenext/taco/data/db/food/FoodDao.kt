package br.com.movilenext.taco.data.db.food

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
abstract class FoodDao {
    @Query("SELECT * FROM food where category_id = :categoryId")
    abstract fun getFoodByCategoryId(categoryId: Int): Flowable<List<FoodEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg foods: FoodEntity)
}