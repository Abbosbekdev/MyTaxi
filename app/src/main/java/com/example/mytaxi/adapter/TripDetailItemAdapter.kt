package com.example.mytaxi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytaxi.R
import com.example.mytaxi.model.TripDetailItemModel
import kotlinx.android.synthetic.main.trip_item_detail_layout.view.*

class TripDetailItemAdapter(val items : List<TripDetailItemModel>):RecyclerView.Adapter<TripDetailItemAdapter.ItemHolder>() {
    inner class ItemHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.trip_item_detail_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var item = items[position]
        holder.itemView.tvTripDetailName.text = item.detailItemName
        holder.itemView.tvTripDetailItem.text = item.detailItem
        holder.itemView.imgDetailTrip.setImageResource(item.imgDetail!!)
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}