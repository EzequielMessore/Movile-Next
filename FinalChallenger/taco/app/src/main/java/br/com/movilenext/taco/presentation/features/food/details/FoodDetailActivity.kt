package br.com.movilenext.taco.presentation.features.food.details

import android.content.Context
import android.content.Intent
import br.com.movilenext.taco.R
import br.com.movilenext.taco.core.extension.contentView
import br.com.movilenext.taco.core.platform.BaseActivity
import br.com.movilenext.taco.databinding.ActivityFoodDetailBinding
import br.com.movilenext.taco.presentation.features.food.list.FoodModel

class FoodDetailActivity : BaseActivity() {

    private val binding: ActivityFoodDetailBinding by contentView(layoutResource())

    override fun layoutResource(): Int = R.layout.activity_food_detail

    override fun init() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.food = getFoodModel()
    }

    override fun insertListener() {

    }

    private fun getFoodModel(): FoodModel = intent.getParcelableExtra(CATEGORY)

    companion object {
        private const val CATEGORY = "category"

        fun newIntent(context: Context, category: FoodModel): Intent =
            Intent(context, FoodDetailActivity::class.java)
                .putExtra(CATEGORY, category)
    }
}
