package com.knowbuddy.friendsforever.frontend.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.knowbuddy.friendsforever.R

class LoginPage: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_login_page, container, false)

        val emailEditText = view.findViewById<EditText>(R.id.login_email)
        val passworEditText = view.findViewById<EditText>(R.id.login_password)
        val loginButton = view.findViewById<Button>(R.id.login_button)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passworEditText.text.toString().trim()

            Toast.makeText(context,"Login Successful", Toast.LENGTH_SHORT).show()
        }
        return view
    }
}
