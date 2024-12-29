package com.knowbuddy.friendsforever.frontend.pages

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.knowbuddy.friendsforever.R
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class HomePage : AppCompatActivity() {

    private lateinit var toolbarr: Toolbar
    private lateinit var navigationView: NavigationView
    private lateinit var drawer: DrawerLayout
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        toolbarr = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.navigation_view)
        setSupportActionBar(toolbarr)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawer = findViewById(R.id.drawerLayout)
        drawerToggle = setupDrawerToggle()
        drawerToggle.isDrawerIndicatorEnabled = true;
        drawerToggle.syncState()

        drawer.addDrawerListener(drawerToggle)
        setupDrawerContent(navigationView)

        val firstCard: CardView = findViewById(R.id.firstCard)
        val secondCard: CardView = findViewById(R.id.secondCard)
        val thirdCard: CardView = findViewById(R.id.thirdCard)
        val firstBtn: Button = findViewById(R.id.firstBtn)
        val secondBtn: Button = findViewById(R.id.secondBtn)
        val thirdBtn: Button = findViewById(R.id.thirdBtn)

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

        // Add onClickListeners to the buttons
        firstBtn.setOnClickListener {
            // Add code to handle the click event
            val intent = Intent(this, Quiz1::class.java)
            startActivity(intent)
        }

        secondBtn.setOnClickListener {
            // Add code to handle the click event
            val intent = Intent(this, Quiz2::class.java)
            startActivity(intent)
        }

        thirdBtn.setOnClickListener {
            // Add code to handle the click event
            val intent = Intent(this, Quiz3::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun selectDrawerItem(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.nav_home -> {
                // Handle the home action
            }

            R.id.nav_scoreboard -> {
                // Handle the scoreboard action
                val intent = Intent(this, ScoreBoard::class.java)
                startActivity(intent)
            }

            R.id.nav_share -> {
                // Handle the share action
            }

            R.id.nav_feedback -> {
                // Handle the feedback action
            }

            R.id.nav_rate -> {
                // Handle the about action
            }
        }
        drawer.closeDrawer(GravityCompat.START)
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            selectDrawerItem(menuItem)
            true
        }
    }


    private fun setupDrawerToggle(): ActionBarDrawerToggle {
        return ActionBarDrawerToggle(
            this,
            drawer,
            toolbarr,
            R.string.drawer_open,
            R.string.drawer_close,
        )
    }
}
