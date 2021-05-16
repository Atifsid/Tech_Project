package com.example.miniproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.miniproject.fragments.AboutFragment
import com.example.miniproject.fragments.FunctionsFragment
import com.example.miniproject.fragments.LogoutFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aboutFragment = AboutFragment()
        val functionsFragment = FunctionsFragment()
        val logOutFragment = LogoutFragment()

        makecurrentFragment(functionsFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_Functions -> makecurrentFragment(functionsFragment)
                R.id.ic_AboutUs -> makecurrentFragment(aboutFragment)
                R.id.ic_LogOut -> makecurrentFragment(logOutFragment)
            }
            true
        }
    }

    private fun makecurrentFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.fl_wrapper, fragment)
        commit()
    }
}