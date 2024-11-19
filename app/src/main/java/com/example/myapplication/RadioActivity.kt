package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioActivity : AppCompatActivity() {

    lateinit var mango: RadioButton
    lateinit var apple: RadioButton
    lateinit var dragon: RadioButton
    lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio)
        mango = findViewById(R.id.mangoButton)
        apple = findViewById(R.id.appleButton5)
        dragon= findViewById(R.id.DragonButton2)
        image = findViewById(R.id.imageView3)

        mango.setOnClickListener{
            image.setImageResource(R.drawable.img)
        }

        apple.setOnClickListener{
            image.setImageResource(R.drawable.img_2)
        }

        dragon.setOnClickListener{
            image.setImageResource(R.drawable.img_1)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}