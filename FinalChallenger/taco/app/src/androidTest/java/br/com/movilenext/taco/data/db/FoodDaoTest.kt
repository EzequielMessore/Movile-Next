package br.com.movilenext.taco.data.db

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import br.com.movilenext.taco.data.db.food.FoodEntity
import br.com.movilenext.taco.data.ws.food.Attribute
import br.com.movilenext.taco.data.ws.food.Energy
import br.com.movilenext.taco.data.ws.food.FoodAttributes
import br.com.movilenext.taco.data.ws.food.VitaminC
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FoodDaoTest {
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
    fun getFoodByFirstCategory() {
        database
            .foodDao()
            .insert(*getFoods().toTypedArray())

        val getAll =
            database
                .foodDao()
                .getFoodByCategoryId(1)
                .blockingFirst()

        assert(getAll.size == 2)
    }

    @Test
    fun insertFood() {
        database
            .foodDao()
            .insert(*getFoods().toTypedArray())

        val list = database
            .foodDao()
            .getFoodByCategoryId(1)
            .blockingFirst()

        assert(list.isNotEmpty())
    }

    private fun getFoods(): List<FoodEntity> {
        val foodEntity = FoodEntity(
            1,
            "Aveia, flocos, crua",
            baseQtd = 100,
            baseUnit = "g",
            vitaminC = VitaminC( "1.35", "mg"),
            categoryId = 1,
            attributes = FoodAttributes(
                carbohydrate = Attribute("1.1", "g"),
                cholesterol = Attribute("1.1", "g"),
                energy = Energy(1.1, 1.444),
                iron = Attribute("1.1", "g"),
                sodium = Attribute("1.1", "g")
            )
        )

        val foodEntity2 = FoodEntity(
            2,
            "Arroz, integral, cozido",
            baseQtd = 100,
            baseUnit = "g",
            vitaminC = VitaminC( "2.99", "kg"),
            categoryId = 1,
            attributes = FoodAttributes(
                carbohydrate = Attribute("1.1", "g"),
                cholesterol = Attribute("1.1", "g"),
                energy = Energy(1.1, 1.444),
                iron = Attribute("1.1", "g"),
                sodium = Attribute("1.1", "g")
            )
        )
        return listOf(foodEntity, foodEntity2)
    }
}