package br.com.ezequiel.kotlin.api

import br.com.ezequiel.kotlin.model.GithubRepositoryResult
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by ezequiel.messore on 03/11/18.
 * ezequiel.messore@s2it.com.br
 */
class RepositoryRetriever {
    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    private val service: GithubService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(GithubService::class.java)
    }

    fun getLanguageRepository(callback: Callback<GithubRepositoryResult>, query: String) {
        val call = service.serchRepository("language:$query")
        call.enqueue(callback)
    }
}