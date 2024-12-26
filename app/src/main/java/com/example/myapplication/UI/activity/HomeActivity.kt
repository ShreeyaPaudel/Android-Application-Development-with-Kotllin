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
import com.example.myapplication.UI.fragment.FirstFragment
import com.example.myapplication.UI.fragment.SecondFragment
import com.example.myapplication.databinding.ActivityDestinationBinding
import com.example.myapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(FirstFragment())

        binding.btnFirst.setOnClickListener {
            replaceFragment(FirstFragment())

        }

        
        binding.btnSecond.setOnClickListener {

            replaceFragment(SecondFragment())
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