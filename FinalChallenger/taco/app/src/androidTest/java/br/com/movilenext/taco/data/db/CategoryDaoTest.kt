package br.com.movilenext.taco.data.db

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import br.com.movilenext.taco.data.db.category.CategoryEntity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CategoryDaoTest {
    private lateinit var database: TacoRoomDatabase

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getContext(),
            TacoRoomDatabase::class.java
        ).build()
    }

    @After
    fun close() {
        database.close()
    }

    @Test
    fun getAllData() {
        val list = listOf(
            CategoryEntity(1, "Category 1"),
            CategoryEntity(2, "Category 2"),
            CategoryEntity(3, "Category 3")
        )

        list.map {
            database
                .categoryDao()
                .insert(it)
        }

        val getAll =
            database
                .categoryDao()
                .getAll()
                .blockingFirst()

        assert(getAll.size == 3)
    }

    @Test
    fun insertCategoryData() {
        val entity = CategoryEntity(1, "Category Test")

        database
            .categoryDao()
            .insert(entity)

        val list = database
            .categoryDao()
            .getAll()
            .blockingFirst()

        assert(list.isNotEmpty())

    }
}