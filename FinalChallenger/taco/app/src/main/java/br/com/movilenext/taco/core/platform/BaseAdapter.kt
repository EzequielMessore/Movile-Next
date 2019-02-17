package br.com.movilenext.taco.core.platform

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

abstract class BaseAdapter<T, A : RecyclerView.ViewHolder> : RecyclerView.Adapter<A>() {

    private val itemsList = ArrayList<T>()

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): A

    abstract override fun onBindViewHolder(viewHolder: A, position: Int)

    var items: List<T>?
        get() = itemsList
        set(value) {
            itemsList.clear()
            if (value != null && value.isNotEmpty()) {
                itemsList.addAll(value)
            }
            notifyDataSetChanged()
        }


    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    fun getItem(position: Int): T {
        return itemsList[position]
    }


}
