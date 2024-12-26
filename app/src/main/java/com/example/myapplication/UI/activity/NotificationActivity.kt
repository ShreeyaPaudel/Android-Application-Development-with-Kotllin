package com.example.myapplication.UI.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.R
import com.example.myapplication.UI.fragment.HomeFragment
import com.example.myapplication.UI.fragment.NotificationFragment
import com.example.myapplication.UI.fragment.PersonFragment
import com.example.myapplication.UI.fragment.SearchFragment
import com.example.myapplication.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {

    lateinit var binding: ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())
        //bottomView is id
        // return gareko value it bhanne variablema aayera bascha
        binding.bottomView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navHome -> replaceFragment(HomeFragment())
                    R.id.navSearch ->  replaceFragment(SearchFragment())
                        R.id.navNotifications -> replaceFragment(NotificationFragment())
                            R.id.navPerson -> replaceFragment(PersonFragment())
                                else ->{}
            }
            true




        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager

        val fragmentTransaction  : FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frame, fragment)

        fragmentTransaction.commit()

    }
}