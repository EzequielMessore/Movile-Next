package br.com.movilenext.taco.core.di

import android.content.Context
import br.com.movilenext.taco.AndroidApplication
import br.com.movilenext.taco.core.scheduler.ISchedulersProvider
import br.com.movilenext.taco.core.scheduler.SchedulersProvider
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
class ApplicationModule(val application: AndroidApplication) {
    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    @Reusable
    fun provideSchedulerProvider(schedulersProvider: SchedulersProvider): ISchedulersProvider = schedulersProvider
}