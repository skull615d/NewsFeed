package com.ldev.newsfeed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ldev.newsfeed.feature.bookmarks_screen.ui.BookmarksScreenFragment
import com.ldev.newsfeed.feature.main_screen.ui.MainScreenFragment
import com.ldev.newsfeed.feature.search_screen.ui.SearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.mainTab -> setFragment(MainScreenFragment())

                R.id.bookmarksTab -> setFragment(BookmarksScreenFragment.newInstance())

                R.id.searchTab -> setFragment(SearchFragment.newInstance())

            }
            true
        }
        bottomNavigationView.selectedItemId = R.id.mainTab
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}