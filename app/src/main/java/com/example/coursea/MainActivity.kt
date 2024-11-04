package com.example.coursea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var buttonRegistration: Button
    private lateinit var buttonEntrance: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonRegistration = findViewById(R.id.registration)
        buttonEntrance = findViewById(R.id.entrance)

        buttonEntrance.setOnClickListener(){
            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
        }

        buttonRegistration.setOnClickListener(){
            val intent = Intent(this, ActivityRegistration::class.java)
            startActivity(intent)
        }
    }
}