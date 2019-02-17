package br.com.movilenext.handson.ui.post

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.movilenext.handson.R
import br.com.movilenext.handson.databinding.ItemPostBinding
import br.com.movilenext.handson.model.Post

/**
 * Created by ezequiel.messore on 14/11/18.
 * ezequiel.messore@s2it.com.br
 */
class PostListAdapter : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    private lateinit var postList: List<Post>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListAdapter.ViewHolder {
        val binding: ItemPostBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_post, parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostListAdapter.ViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return if (::postList.isInitialized) {
            postList.size
        } else {
            0
        }
    }

    fun updatePostList(postList: List<Post>) {
        this.postList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = PostViewModel()

        fun bind(post: Post) {
            viewModel.bind(post)
            binding.viewModel = viewModel
        }
    }
}