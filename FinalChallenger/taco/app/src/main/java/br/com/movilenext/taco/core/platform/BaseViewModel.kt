package br.com.movilenext.taco.core.platform

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    protected val disposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    protected fun <T> filter(query: String, list: List<T>, block: (T) -> Boolean): ArrayList<T> {
        val filteredList = ArrayList<T>()

        if (query.isEmpty()) {
            filteredList.addAll(list)
        } else {
            filteredList.addAll(
                    Observable
                            .just(list)
                            .flatMapIterable { it }
                            .filter { block(it) }
                            .toList().blockingGet()
            )
        }
        return filteredList
    }
}