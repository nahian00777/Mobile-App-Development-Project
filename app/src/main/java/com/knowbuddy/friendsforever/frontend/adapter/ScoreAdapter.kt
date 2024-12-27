package com.knowbuddy.friendsforever.frontend.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.knowbuddy.friendsforever.R
import com.knowbuddy.friendsforever.frontend.models.FriendScore

class ScoreAdapter(private val scores: List<FriendScore>) :
    RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>() {

    // ViewHolder to bind views for each item in RecyclerView
    class ScoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val yourNameTextView: TextView = itemView.findViewById(R.id.your_name_text_view)
        val friendNameTextView: TextView = itemView.findViewById(R.id.friend_name_text_view)
        val scoreTextView: TextView = itemView.findViewById(R.id.score_text_view)
    }

    // Inflates the layout for each item in RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.scoreboard_card, parent, false)
        return ScoreViewHolder(view)
    }

    // Binds data to the views for each item
    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        val friendScore = scores[position]
        holder.yourNameTextView.text = friendScore.yourName
        holder.friendNameTextView.text = friendScore.friendName
        holder.scoreTextView.text = "${friendScore.score}%" // Example score display
    }

    // Returns the total number of items
    override fun getItemCount(): Int {
        return scores.size
    }
}
