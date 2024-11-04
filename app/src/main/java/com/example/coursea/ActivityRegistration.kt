package com.example.coursea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityRegistration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration_window)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.registrationLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageButton1 = findViewById<ImageButton>(R.id.imageButton)
        imageButton1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val emailField = findViewById<EditText>(R.id.editTextEmailAddress)
        val passwordField = findViewById<EditText>(R.id.editTextPassword)
        val button = findViewById<Button>(R.id.button2)

        button.setOnClickListener(){
            val db = DBHelper(this, null)
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                db.addData(email, password)
                Toast.makeText(this, "Регистрация успешна", Toast.LENGTH_LONG).show()

                emailField.text.clear()
                passwordField.text.clear()
            }else{
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            }
        }
    }
}