package com.ldev.newsfeed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ldev.newsfeed.databinding.ActivityMainBinding
import com.ldev.newsfeed.utils.MainActivityActions

class MainActivity : AppCompatActivity(), MainActivityActions {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.fragment_container)
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)
    }

    override fun setGoneBottomNavBar(isGone: Boolean) {
        val bNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bNav?.let { it.isGone = isGone }
    }
}