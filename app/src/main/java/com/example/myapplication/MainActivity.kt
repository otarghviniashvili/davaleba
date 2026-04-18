package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() = with(binding){
        loadFragment(PhotosFragment())
        bottomNavMenu.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.photosItem -> {
                    loadFragment(PhotosFragment())
                }
                R.id.collectionItem -> {
                    loadFragment(CollectionFragment())
                }
                R.id.createItem -> {
                    loadFragment(CreateFragment())
                }
                else -> {
                    loadFragment(PhotosFragment())
                }
            }
            true
        }

    }

    private fun loadFragment(f : Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeHolder, f)
            .commit()
    }
}