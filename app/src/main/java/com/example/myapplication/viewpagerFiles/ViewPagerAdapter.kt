package com.example.myapplication.viewpagerFiles

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fa: FragmentActivity, val list: List<Fragment>) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }

    override fun getItemCount() = list.size
}