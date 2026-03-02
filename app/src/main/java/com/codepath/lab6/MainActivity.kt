package com.codepath.lab6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val parksFragment = ParksFragment.newInstance()

        // Your starter has this already
        val campgroundFragment = CampgroundFragment()

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNav.setOnItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.nav_parks -> parksFragment
                R.id.nav_campgrounds -> campgroundFragment
                else -> parksFragment
            }
            replaceFragment(fragment)
            true
        }

        // default selection on launch
        bottomNav.selectedItemId = R.id.nav_parks
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_frame_layout, fragment)
            .commit()
    }
}