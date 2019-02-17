package br.com.ezequiel.architecturecomponents.chronometerLD

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.SystemClock
import java.util.*

/**
 * Created by ezequiel.messore on 27/10/18.
 * ezequiel.messore@s2it.com.br
 */
class LiveDataTimerViewModel : ViewModel() {
    val elapsedTime = MutableLiveData<Long>()

    init {
        val initialTime = SystemClock.elapsedRealtime()
        val timer = Timer()

        timer.schedule(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - initialTime) / 1000
                elapsedTime.postValue(newValue)
            }

        }, ONE_SECOND, ONE_SECOND)
    }

    companion object {
        const val ONE_SECOND = 1000L
    }

}