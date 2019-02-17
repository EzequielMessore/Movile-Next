package br.com.movilenext.taco.presentation.features.food.list

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.movilenext.taco.R
import br.com.movilenext.taco.core.platform.BaseAdapter
import br.com.movilenext.taco.databinding.ItemFoodBinding
import javax.inject.Inject

class FoodListAdapter @Inject constructor() : BaseAdapter<FoodModel, FoodListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemFoodBinding = DataBindingUtil
                .inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_food,
                        parent,
                        false
                )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(getItem(position))
    }

    var listener: ((FoodModel) -> Unit) = {}

    inner class ViewHolder(private val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(foodModel: FoodModel) {
            binding.food = foodModel
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                listener(foodModel)
            }
        }
    }
}