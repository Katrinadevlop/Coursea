package com.example.coursea

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRegistration = findViewById<Button>(R.id.registration)
        val buttonEntrance = findViewById<Button>(R.id.entrance)

        buttonEntrance.setOnClickListener(){
            setNewLayout(LoginWindowFragment())
        }

        buttonRegistration.setOnClickListener(){
            setNewLayout(RegistrationWindowFragment())
        }
    }

    private fun setNewLayout(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.СonstraintLayouts, fragment)
        fragmentTransaction.commit()
    }
}