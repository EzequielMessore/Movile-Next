package br.com.movilenext.taco.core.interactor

//interface UseCase<in Params, out Source> {
//    fun buildUseCase(params: Params): Source
//    fun run(params: Params): Source
//}

abstract class UseCase<in Params, out Type> where Type : Any {

    abstract fun run(params: Params): Type

    operator fun invoke(params: Params): Type = run(params)

    class None
}