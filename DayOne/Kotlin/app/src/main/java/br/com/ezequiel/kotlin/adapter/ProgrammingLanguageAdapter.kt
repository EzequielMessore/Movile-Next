package br.com.ezequiel.kotlin.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.ezequiel.kotlin.R
import br.com.ezequiel.kotlin.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.programming_language_item.view.*

/**
 * Created by ezequiel.messore on 27/10/18.
 * ezequiel.messore@s2it.com.br
 */
class ProgrammingLanguageAdapter(
        private val items: List<ProgrammingLanguage>,
        private val listener: (ProgrammingLanguage) -> Unit
) : RecyclerView.Adapter<ProgrammingLanguageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.programming_language_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(items[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(item: ProgrammingLanguage, listener: (ProgrammingLanguage) -> Unit) =
                with(itemView) {
                    ivMain.setImageDrawable(ContextCompat.getDrawable(context, item.imageResourceId))
                    tvTitle.text = item.title
                    tvLaunchYear.text = item.year.toString()
                    tvDescription.text = item.description
                    setOnClickListener { listener(item) }
                }

    }
}