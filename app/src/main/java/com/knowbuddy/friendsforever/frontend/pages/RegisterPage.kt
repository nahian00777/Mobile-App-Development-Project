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

class RegisterPage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_register_page, container, false)
        val emailEditText = view.findViewById<EditText>(R.id.signup_email)
        val passwordEditText = view.findViewById<EditText>(R.id.signup_password)
        val confirmPasswordEditText = view.findViewById<EditText>(R.id.signup_confirm)
        val signUpButton = view.findViewById<Button>(R.id.signup_button)
        signUpButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = confirmPasswordEditText.text.toString().trim()
            if(!isValidEmail(email)){
                emailEditText.error="Invalid Email"
            }
            else if (password.length < 8 || password.contains(" ")) {
                passwordEditText.error = "Password must be at least 8 characters and contain no spaces"
            }
            else if (password != confirmPassword) {
                confirmPasswordEditText.error = "Passwords do not match"
            }
            else {
                Toast.makeText(context, "Sign-Up Successful", Toast.LENGTH_SHORT).show()
            // Navigate to LoginFragment
                parentFragmentManager.beginTransaction() .replace(R.id.view_pager, LoginPage())
                    .commit()
            }
        }
        return  view
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
