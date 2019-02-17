package br.com.movilenext.taco.base.mocks

import android.arch.persistence.room.Room
import android.content.Context
import br.com.movilenext.taco.core.di.NetworkModule
import br.com.movilenext.taco.core.di.RoomModule
import br.com.movilenext.taco.data.db.TacoRoomDatabase
import br.com.movilenext.taco.data.db.category.CategoryDao
import br.com.movilenext.taco.data.db.category.CategoryEntity
import br.com.movilenext.taco.data.db.food.FoodDao
import br.com.movilenext.taco.data.db.food.FoodEntity
import io.reactivex.Flowable

open class MockNetworkModule : NetworkModule() {
    override fun provideUrlDomain(): String {
        return "http://localhost:36004/"
    }
}

open class MockRoomdataBase : RoomModule() {
    override fun providesRoomDatabase(context: Context): TacoRoomDatabase {
        return Room.inMemoryDatabaseBuilder(
            context,
            TacoRoomDatabase::class.java
        ).build()
    }

    override fun providesCategoryDao(demoDatabase: TacoRoomDatabase): CategoryDao {
        return object : CategoryDao() {
            override fun getAll(): Flowable<List<CategoryEntity>> {
                return Flowable.just(emptyList())
            }

            override fun insert(vararg categories: CategoryEntity) {

            }

        }
    }

    override fun providesFoodDao(demoDatabase: TacoRoomDatabase): FoodDao {
        return object : FoodDao() {
            override fun getFoodByCategoryId(categoryId: Int): Flowable<List<FoodEntity>> {
                return Flowable.just(emptyList())
            }

            override fun insert(vararg foods: FoodEntity) {

            }

        }
    }
}