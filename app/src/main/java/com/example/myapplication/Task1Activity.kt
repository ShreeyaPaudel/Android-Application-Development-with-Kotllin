package com.example.myapplication

import android.graphics.Paint.Join
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Task1Activity : AppCompatActivity() {
    lateinit var textView_Fries: TextView
    lateinit var textView_deserve: TextView
    lateinit var textView_Join: TextView
    lateinit var textView_fname: TextView
    lateinit var textView_lname: TextView
    lateinit var textView_email: TextView
    lateinit var textView_psw: TextView
    lateinit var button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_task1)

        textView_Fries = findViewById(R.id.Fries)
        textView_deserve = findViewById(R.id.deserve)
        textView_Join = findViewById(R.id.Join)
        button = findViewById(R.id.Sign)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}