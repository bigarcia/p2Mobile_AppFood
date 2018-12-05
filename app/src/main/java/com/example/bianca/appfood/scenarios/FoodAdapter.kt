package com.example.bianca.appfood.scenarios

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bianca.appfood.entities.Food
import com.example.bianca.appfood.utils.GlideApp
import com.example.bianca.appfood.R
import kotlinx.android.synthetic.main.itemlista.view.*

class FoodAdapter(val context: Context, val food: List<Food>) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    var itemClickListener: ((index: Int) -> Unit)? = null

    fun setOnItemClickListener(clique: ((index: Int) -> Unit)){
        this.itemClickListener = clique
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return food.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, food[position], itemClickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, food: Food, itemClickListener: ((index: Int) -> Unit)?) {
            itemView.tvMeal.text = food.meal

            GlideApp.with(context)
                .load(food.mealThumb)
                .placeholder(R.drawable.ic_restaurant_menu_black_24dp)
                .centerCrop()
                .into(itemView.imgFood)

            if(itemClickListener != null) {
                itemView.setOnClickListener {
                    itemClickListener.invoke(adapterPosition)
                }
            }
        }
    }
}
