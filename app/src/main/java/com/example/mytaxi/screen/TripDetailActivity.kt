package com.example.mytaxi.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytaxi.R
import com.example.mytaxi.adapter.TripDetailAdapter
import com.example.mytaxi.model.TripDetailItemModel
import com.example.mytaxi.model.TripDetailModel
import kotlinx.android.synthetic.main.activity_trip_detail.*

class TripDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_detail)

        imgBacTripDetail.setOnClickListener {
            finish()
        }

    }
}