package br.com.movilenext.taco.presentation.features.category

import android.arch.lifecycle.MutableLiveData
import br.com.movilenext.taco.core.platform.BaseViewModel
import br.com.movilenext.taco.domain.interactor.GetCategories
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class CategoryViewModel @Inject constructor(private val getCategories: GetCategories) : BaseViewModel() {

    val state: MutableLiveData<CategoriesState> = MutableLiveData()
    val load by lazy {
        loadCategories()
        MutableLiveData<Any>()
    }
    private var categories: List<CategoryModel> = emptyList()

    fun loadCategories() {
        state.value = CategoriesLoading
        getCategories(null)
            .subscribeBy(
                onNext = {
                    categories = it
                    state.value = CategoriesData(it)
                },
                onError = {
                    state.value = CategoriesError(it)
                }
            ).addTo(disposable)
    }

    fun filterCategories(query: String) {
        val list = filter(query, categories) {
            it.name.toLowerCase().contains(query.toLowerCase())
        }
        state.value = CategoriesData(list)
    }

}