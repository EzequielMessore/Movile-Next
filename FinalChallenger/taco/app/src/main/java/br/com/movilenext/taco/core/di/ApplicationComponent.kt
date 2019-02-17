package br.com.movilenext.taco.core.di

import android.app.Application
import br.com.movilenext.taco.AndroidApplication
import br.com.movilenext.taco.core.di.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        NetworkModule::class,
        ApplicationModule::class,
        RoomModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun networkModule(networkModule: NetworkModule): Builder
        fun roomModule(roomModule: RoomModule): Builder
        fun appModule(appModule: ApplicationModule): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: AndroidApplication)
}