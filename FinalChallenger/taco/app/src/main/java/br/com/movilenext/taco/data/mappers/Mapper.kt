package br.com.movilenext.taco.data.mappers

interface Mapper<From, To> {
    fun transform(from: From): To
    fun transform(from: List<From>): List<To> =
            from.mapTo(mutableListOf()) { transform(it) }

    fun toFrom(to: To): From
    fun toFrom(to: List<To>): List<From> =
            to.mapTo(mutableListOf()) { toFrom(it) }
}