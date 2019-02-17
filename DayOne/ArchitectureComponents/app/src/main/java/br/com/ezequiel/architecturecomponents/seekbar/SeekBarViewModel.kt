package br.com.ezequiel.architecturecomponents.seekbar

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by ezequiel.messore on 27/10/18.
 * ezequiel.messore@s2it.com.br
 */
class SeekBarViewModel : ViewModel() {
    val seekBarValue = MutableLiveData<Int>()
}