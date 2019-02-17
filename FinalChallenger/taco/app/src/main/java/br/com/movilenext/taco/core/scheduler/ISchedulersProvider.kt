package br.com.movilenext.taco.core.scheduler

import io.reactivex.Scheduler

interface ISchedulersProvider {
    fun io(): Scheduler
    fun ui(): Scheduler
}