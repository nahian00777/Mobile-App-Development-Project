package com.knowbuddy.friendsforever.frontend.pages

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.knowbuddy.friendsforever.R
import com.knowbuddy.friendsforever.frontend.adapter.ScoreAdapter
import com.knowbuddy.friendsforever.frontend.models.FriendScore

class ScoreBoard : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_board)

        // Sample data for the scoreboard
        val scores = listOf(
            FriendScore("Nahian", "Kkk", 63),
            FriendScore("Nahian", "Kkh", 68),
            FriendScore("Nahian", "Abc", 75)
        )

        // Find the RecyclerView from the layout
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        // Set up the RecyclerView with a LinearLayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set up the adapter and assign it to the RecyclerView
        val adapter = ScoreAdapter(scores)
        recyclerView.adapter = adapter
    }
}
