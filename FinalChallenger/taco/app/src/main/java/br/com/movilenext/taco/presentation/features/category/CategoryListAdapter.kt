package br.com.movilenext.taco.presentation.features.category

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.movilenext.taco.R
import br.com.movilenext.taco.core.platform.BaseAdapter
import br.com.movilenext.taco.databinding.ItemCategoryBinding
import javax.inject.Inject

class CategoryListAdapter @Inject constructor() : BaseAdapter<CategoryModel, CategoryListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCategoryBinding = DataBindingUtil
                .inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_category,
                        parent,
                        false
                )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(getItem(position))
    }

    var listener: ((CategoryModel) -> Unit) = {}

    inner class ViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(categoryModel: CategoryModel) {
            binding.category = categoryModel
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                listener(categoryModel)
            }
        }
    }
}