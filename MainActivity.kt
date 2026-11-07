package com.guduru.numberdetective

import android.app.Activity
import android.os.Bundle
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import kotlin.random.Random

class MainActivity : Activity() {
    private var secret = Random.nextInt(1, 101)
    private var attempts = 0
    private lateinit var message: TextView
    private lateinit var counter: TextView
    private lateinit var guessInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(28, 36, 28, 28)
            setBackgroundColor(0xFFF4F6FB.toInt())
        }
        root.addView(TextView(this).apply {
            text = "🔎 Number Detective"; textSize = 28f
            setTextColor(0xFF172554.toInt()); typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        }, params())
        root.addView(TextView(this).apply {
            text = "నేను 1 నుండి 100 మధ్య ఒక సంఖ్యను ఎంచుకున్నాను.\nఆ సంఖ్యను కనుక్కోండి!"
            textSize = 18f; gravity = Gravity.CENTER
            setTextColor(0xFF334155.toInt()); setPadding(0, 28, 0, 24)
        }, params())
        guessInput = EditText(this).apply {
            hint = "మీ అంచనా సంఖ్య (1–100)"; inputType = 2
            textSize = 18f; gravity = Gravity.CENTER
        }
        root.addView(guessInput, params())
        root.addView(Button(this).apply {
            text = "Check Number"; textSize = 17f
            setOnClickListener { checkGuess() }
        }, params())
        message = TextView(this).apply {
            text = "మీ మొదటి అంచనాను నమోదు చేయండి."; textSize = 19f
            gravity = Gravity.CENTER; setTextColor(0xFF1E3A8A.toInt())
            setPadding(0, 28, 0, 12)
        }
        root.addView(message, params())
        counter = TextView(this).apply {
            text = "Attempts: 0"; textSize = 16f
            gravity = Gravity.CENTER; setTextColor(0xFF475569.toInt())
        }
        root.addView(counter, params())
        root.addView(Button(this).apply {
            text = "New Game"; setOnClickListener { newGame() }
        }, params())
        setContentView(root)
    }

    private fun params() = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
    ).apply { bottomMargin = 14 }

    private fun checkGuess() {
        val guess = guessInput.text.toString().toIntOrNull()
        if (guess == null || guess !in 1..100) {
            message.text = "దయచేసి 1 నుండి 100 మధ్య సంఖ్య ఇవ్వండి."
            return
        }
        attempts++
        counter.text = "Attempts: $attempts"
        message.text = when {
            guess < secret -> "ఇంకా పెద్ద సంఖ్య ప్రయత్నించండి! ⬆️"
            guess > secret -> "ఇంకా చిన్న సంఖ్య ప్రయత్నించండి! ⬇️"
            else -> "అద్భుతం! 🎉 $secret సరైన సంఖ్య. $attempts ప్రయత్నాల్లో కనుగొన్నారు!"
        }
    }

    private fun newGame() {
        secret = Random.nextInt(1, 101)
        attempts = 0
        counter.text = "Attempts: 0"
        message.text = "కొత్త ఆట ప్రారంభమైంది. మీ అంచనాను నమోదు చేయండి!"
        guessInput.text.clear()
    }
}
