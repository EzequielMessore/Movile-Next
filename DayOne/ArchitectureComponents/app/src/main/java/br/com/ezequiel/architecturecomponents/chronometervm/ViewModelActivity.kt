package br.com.ezequiel.architecturecomponents.chronometervm

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import br.com.ezequiel.architecturecomponents.R
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        val chronometerViewModel =
                ViewModelProviders
                        .of(this)
                        .get(ChronometerViewModel::class.java)

        if (chronometerViewModel.startTime == 0L) {
            val startTime = SystemClock.elapsedRealtime()
            chronometerViewModel.startTime = startTime
            chronometer.base = startTime
        } else {
            chronometer.base = chronometerViewModel.startTime
        }

        chronometer.start()

    }
}
