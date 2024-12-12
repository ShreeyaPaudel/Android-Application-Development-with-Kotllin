package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {
    lateinit var binding: ActivityButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            if (binding.editUsername.text.isEmpty()) {
                binding.editUsername.error = " username can't be empty"
            } else if (binding.editPassword.text.isEmpty()) {
                binding.editPassword.error = "password can't be empty"
            } else {


                val intent = Intent(
                    this@ButtonActivity,
                    DestinationActivity::class.java
                )


                val username: String = binding.editUsername.text.toString()
                val password: String = binding.editPassword.text.toString()

                //key     //value
                intent.putExtra("username", username)
                intent.putExtra("password", password)
                startActivity(intent)

            }
        }

//        binding.btnNavigate.setOnClickListener {
//            val intent = Intent(this@ButtonActivity, RecyclerActivity::class.java)
//            startActivity(intent)
//            finish() // activity dispose granu cha bhane
//
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}