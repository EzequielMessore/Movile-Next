package br.com.ezequiel.kotlin.api

import br.com.ezequiel.kotlin.model.GithubRepositoryResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by ezequiel.messore on 03/11/18.
 * ezequiel.messore@s2it.com.br
 */
interface GithubService {
    @GET("/search/repositories")
    fun serchRepository(
            @Query("q") query: String,
            @Query("sort") sort: String = "stars",
            @Query("order") order: String = "desc"
    ) : Call<GithubRepositoryResult>
}