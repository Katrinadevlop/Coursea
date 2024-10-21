package com.example.coursea

import android.annotation.SuppressLint
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
import kotlinx.coroutines.flow.DEFAULT_CONCURRENCY

class /**/MainActivityLoginWindow : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_window)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageButton = findViewById<ImageButton>(R.id.imageButton)
        imageButton.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val emailField = findViewById<EditText>(R.id.editTextEmailAddress)
        val passwordField = findViewById<EditText>(R.id.editTextPassword)
        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            val db = DBHelper(this, null)
            val inputEmail = emailField.text.toString()
            val inputPassword = passwordField.text.toString()

            if (inputEmail.isNotEmpty() && inputPassword.isNotEmpty()) {
                val cursor = db.getData()

                if (cursor != null && cursor.moveToFirst()) {
                    val dbPassword = cursor.getString(cursor.getColumnIndex(DBHelper.PASSWORD_COL))

                    if (db.isUserRegistered(inputEmail, inputPassword)) {
                        Toast.makeText(this, dbPassword.toString() + "Вход выполнен успешно", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, CoursesActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, dbPassword.toString() + "Неверный пароль", Toast.LENGTH_LONG).show()
                    }
                    cursor.close()
                } else {
                    Toast.makeText(this, "Пользователь не найден", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            }
        }
    }
}