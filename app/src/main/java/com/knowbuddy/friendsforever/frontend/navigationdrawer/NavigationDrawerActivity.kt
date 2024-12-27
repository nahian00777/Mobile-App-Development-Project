package com.knowbuddy.friendsforever.frontend.navigationdrawer

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.knowbuddy.friendsforever.R

class NavigationDrawerActivity : AppCompatActivity() {

    private lateinit var toolbarr: Toolbar
    private lateinit var navigationView: NavigationView
    private lateinit var drawer: DrawerLayout
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_navigation_drawer)
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

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
//            selectDrawerItem(menuItem)
            true
        }
    }

//    private fun selectDrawerItem(menuItem: MenuItem) {
//
//        try {
//            val fragment: Fragment = when (menuItem.itemId) {
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }

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