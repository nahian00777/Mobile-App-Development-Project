package com.knowbuddy.friendsforever.frontend.models


data class Question(
    val question: String,
    val options: List<String>,
    val correctAnswer: Int, // Index of the correct option
    var inputtedAnswer: Int
)
