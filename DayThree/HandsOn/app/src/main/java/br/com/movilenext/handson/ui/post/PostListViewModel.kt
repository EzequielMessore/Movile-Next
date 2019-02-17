package br.com.movilenext.handson.ui.post

import android.arch.lifecycle.MutableLiveData
import android.view.View
import br.com.movilenext.handson.R
import br.com.movilenext.handson.base.BaseViewModel
import br.com.movilenext.handson.model.Post
import br.com.movilenext.handson.model.db.PostDao
import br.com.movilenext.handson.network.PostApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by ezequiel.messore on 12/11/18.
 * ezequiel.messore@s2it.com.br
 */
class PostListViewModel(private val postDao: PostDao) : BaseViewModel() {
    @Inject
    lateinit var postApi: PostApi

    private lateinit var subscription: Disposable
    val loadingVisibility = MutableLiveData<Int>()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts() }
    val postListAdapter: PostListAdapter = PostListAdapter()

    init {
        loadPosts()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadPosts() {
        subscription =
                Observable
                    .fromCallable { postDao.all }
                    .concatMap { dbPostList ->
                        if (dbPostList.isEmpty()) {
                            postApi.getPosts().concatMap { apiPostList ->
                                postDao.insertAll(*apiPostList.toTypedArray())
                                Observable.just(apiPostList)
                            }
                        } else {
                            Observable.just(dbPostList)
                        }
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { onRetrievePostListStart() }
                    .doOnTerminate { onRetrievePostListFinish() }
                    .subscribe(
                        { result -> onRetrievePostListSuccess(result) },
                        { onRetrievePostListError() }
                    )
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(result: List<Post>) {
        postListAdapter.updatePostList(result)
    }

    private fun onRetrievePostListError() {
        errorMessage.value = R.string.post_error
    }
}