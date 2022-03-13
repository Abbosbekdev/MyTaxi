package com.example.mytaxi.screen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytaxi.MainActivity
import com.example.mytaxi.R
import com.example.mytaxi.adapter.TripsAdapter
import com.example.mytaxi.model.TripsModel
import com.example.mytaxi.model.TripsItemHistoryModel
import kotlinx.android.synthetic.main.fragment_trips.*

class TripsHistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trips, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val itemsTripsList = listOf(
            TripsModel("6 Июля, Вторник", listOf(
                TripsItemHistoryModel("улица Sharof Rashidov, Ташкент","5a улица Асадуллы Ходжаева","21:36 - 22:12",R.drawable.gray_car),
                TripsItemHistoryModel("улица Sharof Rashidov, Ташкент","5a улица Асадуллы Ходжаева","14:40 - 15:00",R.drawable.yellow_car),
                TripsItemHistoryModel("улица Sharof Rashidov, Ташкент","5a улица Асадуллы Ходжаева","12:00 - 12:19",R.drawable.black_car)
            )),
            TripsModel("5 Июля, Вторник", listOf(
                TripsItemHistoryModel("улица Sharof Rashidov, Ташкент","5a улица Асадуллы Ходжаева","21:36 - 22:12",R.drawable.gray_car),
                TripsItemHistoryModel("улица Sharof Rashidov, Ташкент","5a улица Асадуллы Ходжаева","14:40 - 15:00",R.drawable.yellow_car),
                TripsItemHistoryModel("улица Sharof Rashidov, Ташкент","5a улица Асадуллы Ходжаева","12:00 - 12:19",R.drawable.black_car)
            ))
        )

        super.onViewCreated(view, savedInstanceState)


        imgBack.setOnClickListener {
            (activity as MainActivity?)?.closeTripsFragment()
        }

        recyclerTrips.layoutManager = LinearLayoutManager(requireActivity())
        recyclerTrips.adapter = TripsAdapter(itemsTripsList)
    }

    companion object {
        @JvmStatic
        fun newInstance() = TripsHistoryFragment()
    }
}