package br.com.movilenext.taco.base.runner

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner
import br.com.movilenext.taco.base.TestApp

class MockTestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, TestApp::class.java.name, context)
    }
}