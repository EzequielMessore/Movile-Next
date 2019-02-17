package br.com.movilenext.taco.base.extensions

import android.content.Context
import android.support.annotation.RawRes
import com.google.gson.Gson
import org.apache.commons.io.IOUtils
import java.nio.charset.Charset


infix fun Context.getJson(@RawRes raw: Int): String {
    val inputStream = resources.openRawResource(raw)
    val json = IOUtils.toString(inputStream, Charset.forName("UTF-8"))
    IOUtils.closeQuietly(inputStream)
    return json
}

inline fun <reified T: Any> String.jsonToObject(): T = Gson().fromJson<T>(this, T::class.java)