package br.com.movilenext.handson.injection.component

import br.com.movilenext.handson.injection.module.NetworkModule
import br.com.movilenext.handson.ui.post.PostListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ezequiel.messore on 12/11/18.
 * ezequiel.messore@s2it.com.br
 */
@Singleton
@Component(
    modules = [
        NetworkModule::class
    ]
)
interface ViewModelInjector {
    fun inject(postListViewModel: PostListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}