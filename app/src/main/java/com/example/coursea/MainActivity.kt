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
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRegistration = findViewById<Button>(R.id.registration)
        val buttonEntrance = findViewById<Button>(R.id.entrance)
        val container = findViewById<ConstraintLayout>(R.id.СonstraintLayouts)
        val firstLayout: View = layoutInflater.inflate(R.layout.activity_login_window, null)
        val secondLayout: View = layoutInflater.inflate(R.layout.activity_registration_window, null)
        val mainActivity:View = layoutInflater.inflate(R.layout.activity_main, null)
        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )
        val imageButton = firstLayout.findViewById<ImageButton>(R.id.imageButton)
        val imageButton1 = secondLayout.findViewById<ImageButton>(R.id.imageButton)

        buttonEntrance.setOnClickListener(){
            container.removeAllViews()
            firstLayout.layoutParams = layoutParams
            container.addView(firstLayout)
        }

        buttonRegistration.setOnClickListener(){
            container.removeAllViews()
            secondLayout.layoutParams = layoutParams
            container.addView(secondLayout)
        }

        imageButton.setOnClickListener(){
            container.removeAllViews()
            container.addView(mainActivity)
        }

        imageButton1.setOnClickListener(){
            container.removeAllViews()
            container.addView(mainActivity)
        }
    }
}