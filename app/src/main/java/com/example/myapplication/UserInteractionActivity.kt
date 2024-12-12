package com.example.myapplication

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class UserInteractionActivity : AppCompatActivity() {
    lateinit var buttonToast: Button
    lateinit var buttonAlert: Button
    lateinit var buttonSnack: Button
    lateinit var main: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_interaction)

        buttonToast = findViewById(R.id.btnToast)
        buttonAlert = findViewById(R.id.btnAlert)
        buttonSnack = findViewById(R.id.btnSnack)
        main = findViewById(R.id.main)

        buttonToast.setOnClickListener {
            Toast.makeText(this@UserInteractionActivity,
                "Invalid Login",
                Toast.LENGTH_LONG
            ).show()

        }

        buttonAlert.setOnClickListener {
            val alert = AlertDialog.Builder(this@UserInteractionActivity)
            alert.setTitle("Confirm")
                .setMessage("Are you sure?")
                .setIcon(R.drawable.img_2)
                .setPositiveButton("Yes",
                    DialogInterface.OnClickListener
                    { dialog, which ->
                        //when user click on yes - logic
                    })
                .setNegativeButton("No",
                    DialogInterface.OnClickListener
                    { dialogInterface, i ->
                        dialogInterface.dismiss()
                    })

            alert.create().show()



        }

        buttonSnack.setOnClickListener {
            Snackbar.make(main,
                "No Internet Connection"
                ,Snackbar.LENGTH_LONG
            ).setAction("RETRY",{
                //LOGIC - WHAT HAPPENS WHEN THE USER CLICK ON RETRY
            }).show()

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}