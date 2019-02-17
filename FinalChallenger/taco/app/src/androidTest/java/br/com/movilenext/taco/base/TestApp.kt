package br.com.movilenext.taco.base

import br.com.movilenext.taco.AndroidApplication
import br.com.movilenext.taco.base.mocks.MockNetworkModule
import br.com.movilenext.taco.base.mocks.MockRoomdataBase
import br.com.movilenext.taco.core.di.ApplicationComponent
import br.com.movilenext.taco.core.di.ApplicationModule
import br.com.movilenext.taco.core.di.DaggerApplicationComponent

class TestApp : AndroidApplication() {

    override fun createComponent(): ApplicationComponent {
        return DaggerApplicationComponent
            .builder()
            .application(this)
            .appModule(ApplicationModule(this))
            .networkModule(MockNetworkModule())
            .roomModule(MockRoomdataBase())
            .build()
    }
}