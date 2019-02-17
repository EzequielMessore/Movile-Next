package br.com.ezequiel.kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.ezequiel.kotlin.R
import br.com.ezequiel.kotlin.model.Repository
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.repository_item.view.*

/**
 * Created by ezequiel.messore on 27/10/18.
 * ezequiel.messore@s2it.com.br
 */
class RepositoryAdapter(
        private val items: List<Repository>,
        private val listener: (Repository) -> Unit
) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(items[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(item: Repository, listener: (Repository) -> Unit) =
                with(itemView) {
                    Glide
                            .with(itemView.context)
                            .load(item.owner.avatar_url)
                            .into(ivMain)


                    tvTitle.text = item.name
                    tvOwner.text = item.owner.login
                    tvDescription.text = item.description
                    setOnClickListener { listener(item) }
                }

    }
}