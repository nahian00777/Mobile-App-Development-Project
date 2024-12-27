package com.knowbuddy.friendsforever.frontend.pages

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.knowbuddy.friendsforever.R

class HomePage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        val firstCard: CardView = findViewById(R.id.firstCard)
        val secondCard: CardView = findViewById(R.id.secondCard)
        val thirdCard: CardView = findViewById(R.id.thirdCard)

        // Add onClickListeners to the cards
        firstCard.setOnClickListener {
            // Add code to handle the click event
            val intent = Intent(this, Quiz1::class.java)
            startActivity(intent)
        }
        secondCard.setOnClickListener {
            // Add code to handle the click event
            val intent = Intent(this, Quiz2::class.java)
            startActivity(intent)
        }
        thirdCard.setOnClickListener {
            // Add code to handle the click event
            val intent = Intent(this, Quiz3::class.java)
            startActivity(intent)
        }
    }
}
