package br.com.movilenext.dagger2.inject


import br.com.movilenext.dagger2.TwitterApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        TwitterModule::class
    ]
)
interface TwitterComponent {
    fun app(): TwitterApplication
//    fun tweeter(): Tweeter
//    fun timeline(): Timeline
}
