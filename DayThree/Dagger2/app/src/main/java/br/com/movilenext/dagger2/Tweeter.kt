package br.com.movilenext.dagger2

import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject
import javax.inject.Singleton

data class Tweet(val tweet: String)

class Tweeter(
    private val api: TwitterApi,
    private val user: String
) {
    fun tweet(tweet: String) {
        api.postTweet(user, tweet)
    }
}

class Timeline(
    private val api: TwitterApi,
    private val user: String
) {
    private val cache: List<Tweet> = emptyList()

    fun get() = cache
    fun loadMore(amount: Int) { /* ... */
    }
}

@Singleton
class TwitterApi @Inject constructor(
    private val client: OkHttpClient
) {
    fun postTweet(user: String, tweet: String) {
        val request = Request.Builder().build()
        client.newCall(request).execute()
    }
}

//private val api = TwitterApi(OkHttpClient())
fun main() {
    val client = OkHttpClient()
    val api = TwitterApi(client)

    val user = "Paulo Salvatore"

    val tweeter = Tweeter(api, user)
    tweeter.tweet("Hello, #DependencyInjection")
    tweeter.tweet("#Kotlin > #Java")

    val timeline = Timeline(api, user)
    timeline.loadMore(20)
    timeline.get().forEach {
        println("${it.tweet}\n")
    }
}

class Streaming @Inject constructor() {
    fun register(app: TwitterApplication) { /* ... */ }
}
