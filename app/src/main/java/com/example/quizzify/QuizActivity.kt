package com.example.quizzify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
    }

    fun tapBrand(view: View) {
        val intent = Intent(this, BrandQuizActivity::class.java)
        startActivity(intent)
        finish()
    }



    fun goBack(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun tapProgram(view: View) {
        val intent = Intent(this, ProgrammingQuizActivity::class.java)
        startActivity(intent)
        finish()
    }
}