package com.example.mytaxi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytaxi.R
import com.example.mytaxi.model.TripsItemHistoryModel
import kotlinx.android.synthetic.main.trips_item_layout.view.*

interface TripsHistoryCallback{
    fun onClick(item : TripsItemHistoryModel)
}

class TripsHistoryItemAdapter(val items : List<TripsItemHistoryModel>,val callback: TripsHistoryCallback) : RecyclerView.Adapter<TripsHistoryItemAdapter.ItemHolder>() {
    inner class ItemHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.trips_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var item = items[position]
        holder.itemView.tvLocation1.text = item.location1
        holder.itemView.tvLocation2.text = item.location2
        holder.itemView.tvDateName.text = item.dateName
        holder.itemView.imgTrips.setImageResource(item.carImg!!)
        holder.itemView.setOnClickListener {
            callback.onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}