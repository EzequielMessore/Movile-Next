package br.com.movilenext.taco.core.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class SchedulersProvider @Inject constructor() : ISchedulersProvider {
    override fun io() = Schedulers.io()
    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
}