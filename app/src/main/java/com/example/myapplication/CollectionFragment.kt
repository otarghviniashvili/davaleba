package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentCollectionBinding
import com.example.myapplication.viewpagerFiles.MyFragment
import com.example.myapplication.viewpagerFiles.NotMineFragment
import com.example.myapplication.viewpagerFiles.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class CollectionFragment : Fragment() {

    lateinit var binding : FragmentCollectionBinding

    private val fList = listOf<Fragment>(
        MyFragment(), NotMineFragment()
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCollectionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        val myAdapter = ViewPagerAdapter(requireActivity(), fList)
        vp.adapter = myAdapter

        val tList = listOf<String>(
            "Mine", "Not Mine"
        )

        TabLayoutMediator(tabLayout,vp){tab, position ->
            tab.text = tList[position]
        }.attach()
    }

}