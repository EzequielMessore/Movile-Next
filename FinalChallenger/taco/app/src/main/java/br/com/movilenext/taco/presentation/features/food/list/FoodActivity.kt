package br.com.movilenext.taco.presentation.features.food.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.support.v7.widget.SearchView
import android.view.Menu
import br.com.movilenext.taco.R
import br.com.movilenext.taco.core.extension.contentView
import br.com.movilenext.taco.core.platform.InjectableActivity
import br.com.movilenext.taco.databinding.ActivityFoodBinding
import br.com.movilenext.taco.presentation.features.category.CategoryModel
import br.com.movilenext.taco.presentation.features.food.details.FoodDetailActivity
import kotlinx.android.synthetic.main.activity_food.*
import kotlinx.android.synthetic.main.container_error.view.*
import javax.inject.Inject

class FoodActivity : InjectableActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var adapter: FoodListAdapter

    private val binding: ActivityFoodBinding by contentView(layoutResource())

    private val viewModel by lazy {
        ViewModelProviders
                .of(this, viewModelFactory)
                .get(FoodViewModel::class.java)
    }

    override fun layoutResource() = R.layout.activity_food

    override fun init() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel.categoryImage = getCategory().getImage()
        binding.viewModel = viewModel
        viewModel.loadFoodsByCategory(getCategory().id)

        bindViewModels()
        rv_food.adapter = adapter

        adapter.listener = {
            startActivity(FoodDetailActivity.newIntent(this, it))
        }

    }

    override fun insertListener() {
        container_error.btn_try_again.setOnClickListener {
            viewModel.loadFoodsByCategory(getCategory().id)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search, menu)
        menu?.let {
            val item = it.findItem(R.id.menuSearch)
            val searchView = item.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    return false
                }

                override fun onQueryTextChange(searchText: String): Boolean {
                    viewModel.filterCategories(searchText)
                    return true
                }
            })

            searchView.setOnCloseListener {
                viewModel.filterCategories("")
                false
            }
        }
        return super.onCreateOptionsMenu(menu)
    }


    private fun bindViewModels() {
        viewModel.state.observe(this, Observer {
            it?.let { state ->
                handleCategoriesState(state)
            }
        })
    }

    private fun handleCategoriesState(state: FoodState) {
        when (state) {
            is FoodLoading -> {
                loading.show()
            }
            is FoodData -> {
                loading.hide()
                adapter.items = state.data
            }
            is FoodError -> {
                loading.hide()
            }
        }
    }

    private fun getCategory(): CategoryModel = intent.getParcelableExtra(CATEGORY)

    companion object {
        private const val CATEGORY = "category"

        fun newIntent(context: Context, category: CategoryModel): Intent =
                Intent(context, FoodActivity::class.java)
                        .putExtra(CATEGORY, category)
    }


}
