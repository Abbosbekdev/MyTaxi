package com.example.mytaxi.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytaxi.R
import com.example.mytaxi.model.TripsItemHistoryModel
import com.example.mytaxi.model.TripsModel
import com.example.mytaxi.screen.TripDetailActivity
import kotlinx.android.synthetic.main.trips_date_layout.view.*

class TripsAdapter(val items: List<TripsModel>) : RecyclerView.Adapter<TripsAdapter.ItemHolder>() {
    inner class ItemHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.trips_date_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var item = items[position]
        holder.itemView.tvTitleDate.text = item.title
        holder.itemView.recyclerTripsItem.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.itemView.recyclerTripsItem.adapter = TripsHistoryItemAdapter(item.tripsList,object : TripsHistoryCallback{
            override fun onClick(item: TripsItemHistoryModel) {
                holder.itemView.context.startActivity(Intent(holder.itemView.context,TripDetailActivity::class.java))
            }
        })
    }

    override fun getItemCount(): Int {
        return items.count()
    }

}