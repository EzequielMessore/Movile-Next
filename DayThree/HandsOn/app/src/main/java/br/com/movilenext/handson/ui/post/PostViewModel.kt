package br.com.movilenext.handson.ui.post

import android.arch.lifecycle.MutableLiveData
import br.com.movilenext.handson.base.BaseViewModel
import br.com.movilenext.handson.model.Post

/**
 * Created by ezequiel.messore on 14/11/18.
 * ezequiel.messore@s2it.com.br
 */
class PostViewModel : BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post) {
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle() = postTitle

    fun getPostBody() = postBody
}