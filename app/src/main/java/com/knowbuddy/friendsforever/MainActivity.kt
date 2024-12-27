package com.knowbuddy.friendsforever

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.knowbuddy.friendsforever.frontend.navigationdrawer.NavigationDrawerActivity
import com.knowbuddy.friendsforever.frontend.pages.HomePage
import com.knowbuddy.friendsforever.frontend.pages.LoginPage
import com.knowbuddy.friendsforever.frontend.pages.RegisterPage
import com.knowbuddy.friendsforever.frontend.pages.ScoreBoard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.opening_page)

        val loginButton: Button = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val intent = Intent(this, NavigationDrawerActivity::class.java)
            startActivity(intent)
        }
        val signUpButton: Button = findViewById(R.id.signUpButton)
        signUpButton.setOnClickListener {
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
        }
    }
}