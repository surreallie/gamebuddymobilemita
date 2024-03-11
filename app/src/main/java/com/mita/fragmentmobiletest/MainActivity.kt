package com.mita.fragmentmobiletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView =  findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.HomePageView ->{
                    replaceFragment(homeFragment())
                    true
                }
                R.id.UsersPageView ->{
                    replaceFragment(usersFragment())
                    true
                }
                R.id.AccPageView ->{
                    replaceFragment(accountsFragment())
                    true
                }
                else -> false
            }
        }
        replaceFragment(homeFragment())

    }
    private fun replaceFragment( fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frameContainer,fragment).commit()
    }
}