package com.ldev.newsfeed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ldev.newsfeed.feature.main_screen.ui.MainScreenFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container, MainScreenFragment())
            .commit()
    }
}