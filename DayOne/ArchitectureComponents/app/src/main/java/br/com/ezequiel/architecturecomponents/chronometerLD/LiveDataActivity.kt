package br.com.ezequiel.architecturecomponents.chronometerLD

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.ezequiel.architecturecomponents.R
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity() {

    private val liveDataTimerViewModel by lazy {
        ViewModelProviders
                .of(this)
                .get(LiveDataTimerViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)



        subscribe()
    }

    @SuppressLint("SetTextI18n")
    private fun subscribe() {
        val elapsedTimeObserver = Observer<Long> { time ->
            tv_timer.text = "$time segundos se passaram."
        }
        liveDataTimerViewModel.elapsedTime.observe(this, elapsedTimeObserver)
    }
}
