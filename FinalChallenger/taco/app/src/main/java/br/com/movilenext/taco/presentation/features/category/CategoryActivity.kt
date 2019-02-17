package br.com.movilenext.taco.presentation.features.category

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.SearchView
import android.view.Menu
import br.com.movilenext.taco.R
import br.com.movilenext.taco.core.extension.contentView
import br.com.movilenext.taco.core.platform.InjectableActivity
import br.com.movilenext.taco.databinding.ActivityCategoryBinding
import br.com.movilenext.taco.presentation.features.food.list.FoodActivity
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.container_error.view.*
import javax.inject.Inject

class CategoryActivity : InjectableActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var adapter: CategoryListAdapter

    private val binding: ActivityCategoryBinding by contentView(layoutResource())

    private val viewModel by lazy {
        ViewModelProviders
            .of(this, viewModelFactory)
            .get(CategoryViewModel::class.java)
    }

    override fun layoutResource() = R.layout.activity_category

    override fun init() {
        binding.viewModel = viewModel
        viewModel.load

        bindViewModels()
        rv_category.adapter = adapter
    }

    override fun insertListener() {
        container_error.btn_try_again.setOnClickListener {
            viewModel.loadCategories()
        }
        adapter.listener = {
            startActivity(FoodActivity.newIntent(this, it))
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

    private fun handleCategoriesState(state: CategoriesState) {
        when (state) {
            is CategoriesLoading -> {
                loading.show()
            }
            is CategoriesData -> {
                loading.hide()
                adapter.items = state.data
            }
            is CategoriesError -> {
                loading.hide()
            }
        }
    }


}
