package com.example.coursea

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

@Suppress("UNREACHABLE_CODE")
class LoginWindowFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_login_window, container, false)

        val buttonExitBack = view?.findViewById<Button>(R.id.imageButton)
        buttonExitBack?.setOnClickListener {
            Exit()
        }
    }

    private fun Exit(){
        val intent = Intent(requireActivity(), MainActivity::class.java)
        startActivity(intent)
    }

}