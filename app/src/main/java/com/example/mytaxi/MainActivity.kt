package com.example.mytaxi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.mytaxi.screen.HomeFragment
import com.example.mytaxi.screen.TripsHistoryFragment
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var homeFragment = HomeFragment.newInstance()
    var tripsFragment = TripsHistoryFragment.newInstance()
    var activFragment : Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.flContainer,tripsFragment,tripsFragment.tag).hide(tripsFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.flContainer,homeFragment,homeFragment.tag).hide(homeFragment).commit()
        supportFragmentManager.beginTransaction().show(activFragment).commit()


        val options = GoogleMapOptions()
            .mapId("c363225112a79c3e")
        val mapFragment = SupportMapFragment.newInstance(options)


        nav_view.setNavigationItemSelectedListener {
            if (it.itemId == R.id.ActionTrip){
                supportFragmentManager.beginTransaction().hide(homeFragment).show(tripsFragment).commit()
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            true
        }
    }

    fun openDrawer() {
        drawerLayout.openDrawer(GravityCompat.START)
    }

    fun closeTripsFragment(){
        supportFragmentManager.beginTransaction().hide(tripsFragment).show(homeFragment).commit()
    }
}