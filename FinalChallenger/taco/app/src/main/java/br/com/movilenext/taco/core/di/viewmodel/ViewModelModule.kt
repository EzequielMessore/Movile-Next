package br.com.movilenext.taco.core.di.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.movilenext.taco.presentation.features.category.CategoryViewModel
import br.com.movilenext.taco.presentation.features.food.list.FoodViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    abstract fun bindsCategoryViewModel(viewModel: CategoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FoodViewModel::class)
    abstract fun bindsFoodViewModel(viewModel: FoodViewModel): ViewModel

}