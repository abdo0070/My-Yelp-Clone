package com.abdalla_mmdouh.myyelpcolne

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RestaurantsAdapter(val context: Context,val restaurants: List<YelpSearchResult>) : RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate tne layout for the rows
        val view = LayoutInflater.from(context).inflate(R.layout.restaurant_layout,null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Pass The Data
        val restaurant = restaurants[position]
        holder.bind(restaurant)
    }

    override fun getItemCount() = restaurants.size
    open inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(restaurant: YelpSearchResult) {

        }
    }
}
