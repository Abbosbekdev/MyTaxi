package com.example.mytaxi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytaxi.R
import com.example.mytaxi.model.TripDetailModel
import kotlinx.android.synthetic.main.trip_detail_layout.view.*

class TripDetailAdapter(val items : List<TripDetailModel>):RecyclerView.Adapter<TripDetailAdapter.ItemHolder>() {
    inner class ItemHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.trip_detail_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var item = items[position]
        holder.itemView.tvTripsDetailTitle.text = item.titleDetail
        holder.itemView.tripDetailItemRecycler.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.itemView.tripDetailItemRecycler.adapter = TripDetailItemAdapter(item.detailList)
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}