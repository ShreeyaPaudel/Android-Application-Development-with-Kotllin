package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.FruitsAdapter

class RecyclerActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var imageList = ArrayList<Int>()
    var fruitsTitle = ArrayList<String>()
    var fruitsDesc = ArrayList<String>()

    lateinit var adapter: FruitsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler)
        recyclerView = findViewById(R.id.recyclerView)

        imageList.add(R.drawable.img)
        imageList.add(R.drawable.img_2)
        imageList.add(R.drawable.img_1)

        fruitsTitle.add("Mango")
        fruitsTitle.add("Apple")
        fruitsTitle.add("Dragon Fruit")

        fruitsDesc.add("This is mango")
        fruitsDesc.add("This is apple")
        fruitsDesc.add("This is dragon fruit")

        adapter = FruitsAdapter(
            this@RecyclerActivity,
            imageList,fruitsTitle, fruitsDesc
        )

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(
            this@RecyclerActivity, 2
        )




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}