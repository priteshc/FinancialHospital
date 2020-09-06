package com.example.financialhospital.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.financialhospital.R
import com.example.financialhospital.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.mainfragment.*

class MainFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) :View {

        return inflater.inflate(R.layout.mainfragment, container, false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupViewPager(viewpager)
        viewpager.setCurrentItem(0)

        button_view.setOnCheckedChangeListener { radioGroup, i ->

            if (i == R.id.radio1){
                viewpager.currentItem = 0
            }
            else if (i == R.id.radio2){
                viewpager.currentItem = 1
            }
            else if (i == R.id.radio3){
                viewpager.currentItem = 2
            }
            else if (i == R.id.radio4){
                viewpager.currentItem = 3
            }

        }


         right.setOnClickListener{

             if (viewpager.currentItem == 3) {
                 Toast.makeText(context, "finish", Toast.LENGTH_SHORT).show()
             } else {
                 viewpager.setCurrentItem(viewpager.currentItem + 1)
             }

         }

        left.setOnClickListener{

            if (viewpager.currentItem == 0) {
                Toast.makeText(context, "finish", Toast.LENGTH_SHORT).show()
            } else {
                viewpager.setCurrentItem(viewpager.currentItem - 1)
            }

        }

        viewpager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    radio1.isChecked = true
                } else if (position == 1) {
                    radio2.isChecked = true
                } else if (position == 2) {
                    radio3.isChecked = true
                } else if (position == 3) {
                    radio4.isChecked = true
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

    }



    fun setupViewPager(viewpager : ViewPager){

        if(viewpager != null) {
            val adapter = ViewPagerAdapter(childFragmentManager)
            adapter.addFragment(FragmentTab())
            adapter.addFragment(BetterFragment())
            adapter.addFragment(RiskFragment())
            adapter.addFragment(FamilyFragment())
            viewpager.adapter = adapter
        }

    }


}