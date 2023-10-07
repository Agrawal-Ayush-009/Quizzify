package com.example.quizzify

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinalScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_score)

        val score = intent.getIntExtra("SCORE", 0)

        findViewById<TextView>(R.id.score).setText("Score : $score").toString()

        val percent = (score*100)/50
        findViewById<TextView>(R.id.percent).setText("$percent% Score").toString()


        if(percent < 50){
            findViewById<TextView>(R.id.wish).setText("Good!").toString()
            findViewById<TextView>(R.id.percent).setTextColor(Color.parseColor("#d00000"))
        }else{
            findViewById<TextView>(R.id.wish).setText("Congrats!").toString()
            findViewById<TextView>(R.id.percent).setTextColor(Color.parseColor("#16db65"))
        }

    }

    fun goBack(view: View) {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
        finish()
    }
}