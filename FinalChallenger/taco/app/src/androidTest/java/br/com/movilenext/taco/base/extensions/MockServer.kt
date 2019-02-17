package br.com.movilenext.taco.base.extensions

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

fun MockWebServer.inject(code: Int, json: String) {
    this.enqueue(
        MockResponse()
            .setResponseCode(code)
            .setBody(json)
    )
}