package com.example.financialhospital

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.financialhospital.fragment.DashboardFragment
import com.example.financialhospital.fragment.MainFragment
import com.example.financialhospital.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loadfragment(MainFragment())

        bottomNavigationView.selectedItemId = R.id.setting

        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {

           when(it.itemId){

               R.id.dashboard -> loadfragment(DashboardFragment())

               R.id.setting -> loadfragment(MainFragment())

               R.id.profile -> loadfragment(ProfileFragment())
           }

            false
        })
    }


    fun loadfragment(fragment : Fragment): Boolean{

        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
            return true
        }
        return false
    }
}