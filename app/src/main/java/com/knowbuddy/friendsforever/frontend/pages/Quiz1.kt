package com.knowbuddy.friendsforever.frontend.pages

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.graphics.blue
import androidx.core.graphics.toColor
import com.knowbuddy.friendsforever.R
import com.knowbuddy.friendsforever.frontend.models.Question

class Quiz1 : Activity() {
    private val questions = listOf(
        Question(
            "What is Faysal Taysir's nickname?", listOf(
                "Taysir",
                "Fay",
                "Fayz",
                "Circuit"
            ), 3, 5
        ),
        Question(
            "What is Faysal Taysir's student ID?", listOf(
                "2004098",
                "2004109",
                "2004110",
                "2004120"
            ), 1, 5
        ),
        Question(
            "Which hall does Faysal Taysir stay in?", listOf(
                "South",
                "BBH",
                "SRH",
                "North"
            ), 3, 5
        ),
        Question(
            "Where is Faysal Taysir's hometown?", listOf(
                "Dhaka",
                "Chittagong",
                "Khulna",
                "Rajshahi"
            ), 2, 5
        ),
        Question(
            "What is Faysal Taysir's biggest dream?", listOf(
                "Building a multi-billion dollar tech company",
                "Traveling the world",
                "Marrying a beautiful girl",
                "Becoming a professional athlete"
            ), 2, 5
        )


    )

    private var currentQuestionIndex = 0
    private var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz1)

        // Load the first question
        loadQuestion()

        // Handle "Next" button click
        findViewById<Button>(R.id.btnNext).setOnClickListener {
            handleNextButton()
        }
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            handleBackButton()
        }
    }

    private fun loadQuestion() {
        val question = questions[currentQuestionIndex]
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val radioGroup = findViewById<RadioGroup>(R.id.rgOptions)
        val progress = findViewById<ProgressBar>(R.id.progressBar)
        val tvNumber = findViewById<TextView>(R.id.tvNumber)
        // Set question text
        progress.max = questions.size
        progress.progress = currentQuestionIndex
        tvQuestion.text = question.question
        val index = currentQuestionIndex + 1
        tvNumber.text = index.toString()


        // Set options
        radioGroup.clearCheck()
        question.options.forEachIndexed { index, option ->
            val radioButton = radioGroup.getChildAt(index) as RadioButton
            radioButton.text = option
            radioButton.isEnabled = true
            radioGroup.check(questions[currentQuestionIndex].inputtedAnswer)

        }
        val indexToCheck =
            questions[currentQuestionIndex].inputtedAnswer // Replace with the desired index
        if (indexToCheck in 0 until radioGroup.childCount) {
            val radioButtonToCheck = radioGroup.getChildAt(indexToCheck) as RadioButton
            radioGroup.check(radioButtonToCheck.id)
        }
    }

    private fun handleNextButton() {
        val radioGroup = findViewById<RadioGroup>(R.id.rgOptions)
        val selectedOptionId = radioGroup.checkedRadioButtonId

        if (selectedOptionId != -1) {
            val selectedRadioButton = findViewById<RadioButton>(selectedOptionId)
            val selectedIndex = radioGroup.indexOfChild(selectedRadioButton)
            questions[currentQuestionIndex].inputtedAnswer = selectedIndex
            // Check if the answer is correct
            if (selectedIndex == questions[currentQuestionIndex].correctAnswer) {

                score++
            }

            // Move to the next question or finish the quiz
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                loadQuestion()

            } else {
                showResults()
            }
        } else {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleBackButton() {
        currentQuestionIndex--
        if (currentQuestionIndex < questions.size) {
            loadQuestion()
        }

    }

    private fun showResults() {
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val radioGroup = findViewById<RadioGroup>(R.id.rgOptions)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val progress = findViewById<ProgressBar>(R.id.progressBar)

        progress.progress = currentQuestionIndex
        // Hide RadioGroup and show the result
        radioGroup.visibility = RadioGroup.GONE
        btnNext.visibility = Button.GONE
        btnBack.setOnClickListener {
            val intent = Intent(this@Quiz1, HomePage::class.java)
            startActivity(intent)
        }
        tvQuestion.text = "Quiz finished! Your score is $score out of ${questions.size}."
    }
}
