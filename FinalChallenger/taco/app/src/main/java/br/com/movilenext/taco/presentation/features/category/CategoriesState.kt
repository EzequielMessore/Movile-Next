package br.com.movilenext.taco.presentation.features.category

sealed class CategoriesState
data class CategoriesData(val data: List<CategoryModel>) : CategoriesState()
object CategoriesLoading : CategoriesState()
data class CategoriesError(val error: Throwable) : CategoriesState()