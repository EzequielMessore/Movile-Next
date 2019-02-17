package br.com.movilenext.handson.network

import br.com.movilenext.handson.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by ezequiel.messore on 12/11/18.
 * ezequiel.messore@s2it.com.br
 */
interface PostApi {
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}