package br.com.movilenext.taco.core.extension

fun String?.getSafe() = this ?: ""

fun String.toFormat(): String {
    val double = this.toDoubleOrNull()
    return if (double == null) {
        this
    } else {
        String.format("%.2f", double)
    }
}