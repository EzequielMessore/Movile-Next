package br.com.ezequiel.architecturecomponents.chronometerLD

/**
 * Created by ezequiel.messore on 27/10/18.
 * ezequiel.messore@s2it.com.br
 */
inline fun <T> guard(
        receiver: T?,
        block: () -> Nothing
): T {
    if (receiver == null) {
        block()
    }

    return receiver
}