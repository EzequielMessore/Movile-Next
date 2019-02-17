package br.com.movilenext.handson.utils

import android.content.ContextWrapper
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * Created by ezequiel.messore on 12/11/18.
 * ezequiel.messore@s2it.com.br
 */
fun View.getParentActivity(): AppCompatActivity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}