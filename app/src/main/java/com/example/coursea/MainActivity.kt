package com.example.coursea

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {
    private lateinit var buttonRegistration: Button
    private lateinit var buttonEntrance: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonRegistration = findViewById(R.id.registration)
        buttonEntrance = findViewById(R.id.entrance)

        buttonEntrance.setOnClickListener(){
            val intent = Intent(this, MainActivityLoginWindow::class.java)
            startActivity(intent)
        }

        buttonRegistration.setOnClickListener(){
            val intent = Intent(this, ActivityRegistrationWindow::class.java)
            startActivity(intent)
        }
    }
}