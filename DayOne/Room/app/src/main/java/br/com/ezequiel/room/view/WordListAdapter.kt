package br.com.ezequiel.room.view

import android.content.Context
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.ezequiel.room.R
import br.com.ezequiel.room.model.Word

/**
 * Created by ezequiel.messore on 27/10/18.
 * ezequiel.messore@s2it.com.br
 */
class WordListAdapter(context: Context) : Adapter<WordListAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    var words: List<Word> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.word_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        if (words.isEmpty()) {
            holder.wordItemView.text = "No Words"
        } else {
            holder.wordItemView.text = words[position].word
        }
    }

    override fun getItemCount() = words.size

    class WordViewHolder(view: View) : ViewHolder(view) {
        val wordItemView: TextView = view.findViewById(R.id.textView)
    }
}