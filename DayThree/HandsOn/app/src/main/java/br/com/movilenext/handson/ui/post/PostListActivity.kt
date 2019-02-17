package br.com.movilenext.handson.ui.post

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import br.com.movilenext.handson.R
import br.com.movilenext.handson.databinding.ActivityPostListBinding
import br.com.movilenext.handson.injection.ViewModelFactory
import br.com.movilenext.handson.utils.contentView

/**
 * Created by ezequiel.messore on 12/11/18.
 * ezequiel.messore@s2it.com.br
 */
class PostListActivity : AppCompatActivity() {

    private val binding: ActivityPostListBinding by contentView(R.layout.activity_post_list)
    private val viewModel: PostListViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory(this)).get(PostListViewModel::class.java)
    }
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

        viewModel.errorMessage.observe(this, Observer { error ->
            if (error != null) {
                showError(error)
            } else {
                hideError()
            }
        })

    }

    private fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }
}