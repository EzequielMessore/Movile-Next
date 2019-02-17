package br.com.movilenext.handson.base

import android.arch.lifecycle.ViewModel
import br.com.movilenext.handson.injection.component.DaggerViewModelInjector
import br.com.movilenext.handson.injection.component.ViewModelInjector
import br.com.movilenext.handson.injection.module.NetworkModule
import br.com.movilenext.handson.ui.post.PostListViewModel

/**
 * Created by ezequiel.messore on 12/11/18.
 * ezequiel.messore@s2it.com.br
 */
abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector =
        DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }
}