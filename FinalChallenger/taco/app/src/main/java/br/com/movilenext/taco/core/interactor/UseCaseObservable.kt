package br.com.movilenext.taco.core.interactor

import br.com.movilenext.taco.core.scheduler.ISchedulersProvider
import io.reactivex.Observable

abstract class UseCaseObservable<in Params, T> constructor(private val schedulersProvider: ISchedulersProvider) :
    UseCase<Params, Observable<T>>() {

    abstract fun buildUseCase(params: Params): Observable<T>

    override fun run(params: Params): Observable<T> =
        buildUseCase(params)
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.ui())

}

