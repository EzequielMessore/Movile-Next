package br.com.movilenext.databinding.utils

import android.app.Activity
import android.databinding.BaseObservable
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import kotlin.reflect.KProperty

/**
 * Created by ezequiel.messore on 10/11/18.
 * ezequiel.messore@s2it.com.br
 */
fun <T : ViewDataBinding> contentView(@LayoutRes layoutRes: Int): SetContentView<T> = SetContentView(layoutRes)


class SetContentView<out T : ViewDataBinding>(@LayoutRes private val layoutRes: Int) {
    private var value: T? = null

    operator fun getValue(thisRef: Activity, property: KProperty<*>): T {
        value = value ?: DataBindingUtil.setContentView(thisRef, layoutRes)!!
        return value!!
    }
}

fun <R : BaseObservable, T : Any> bindable(
        value: T, bindingRes: Int): BindableDelegate<R, T> {
    return BindableDelegate(value, bindingRes)
}

class BindableDelegate<in R : BaseObservable, T : Any>(
        private var value: T, private val bindingEntry: Int) {
    operator fun getValue(thisRef: R, property: KProperty<*>):
            T = value

    operator fun setValue(thisRef: R, property: KProperty<*>,
                          value: T) {
        this.value = value
        thisRef.notifyPropertyChanged(bindingEntry)
    }
}
