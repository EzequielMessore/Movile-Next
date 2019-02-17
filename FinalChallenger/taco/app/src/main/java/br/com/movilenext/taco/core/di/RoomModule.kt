package br.com.movilenext.taco.core.di

import android.arch.persistence.room.Room
import android.content.Context
import br.com.movilenext.taco.data.db.TacoRoomDatabase
import br.com.movilenext.taco.data.db.category.CategoryDao
import br.com.movilenext.taco.data.db.food.FoodDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class RoomModule {

    @Singleton
    @Provides
    open fun providesRoomDatabase(context: Context): TacoRoomDatabase =
        Room.databaseBuilder(context.applicationContext, TacoRoomDatabase::class.java, "taco-db").build()

    @Singleton
    @Provides
    internal open fun providesCategoryDao(demoDatabase: TacoRoomDatabase): CategoryDao = demoDatabase.categoryDao()

    @Singleton
    @Provides
    internal open fun providesFoodDao(demoDatabase: TacoRoomDatabase): FoodDao = demoDatabase.foodDao()

}