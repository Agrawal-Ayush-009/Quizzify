package com.example.quizzify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class ProgrammingQuizActivity : AppCompatActivity() {
    var score = 0;
    val images = arrayOf("kotlin_logo", "valorant_logo", "javakalogo", "python_logo", "android_studio_icon")
    val questions = arrayOf("Which Programming language\nlogo is this?",
        "Which of the following language\nused in Valorant Game?",
        "What is not the file extension of this\nProgramming Language?",
        "Which of the following is not a\nlibrary of this Language?",
        "Which of the following is correct\nname for this?")
    var idx = 1
    val options = arrayOf(arrayOf("KornShell", "Kojo", "Kotlin", "Karel", "Kotlin"),
        arrayOf("C#", "Kojo", "C++", "Go-Lang", "Go-Lang"),
        arrayOf(".jav", ".jvx", ".java", ".class", ".jvx"),
        arrayOf("TensorFlow", "NumPy", "Apache", "Seaborn", "Apache"),
        arrayOf("Android Coder", "Android Studio", "Android Debugger", "Android Compiler",  "Android Studio"))

    var clickedButton = arrayListOf<AppCompatButton>()

    private lateinit var quizImageView: ImageView
    private lateinit var option1: AppCompatButton
    private lateinit var option2: AppCompatButton
    private lateinit var option3: AppCompatButton
    private lateinit var option4: AppCompatButton
    private lateinit var nextButton: AppCompatButton
    private lateinit var quiz_question: TextView
    private lateinit var quiz_heading: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_programming_quiz)

        quizImageView = findViewById(R.id.img1)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)
        nextButton = findViewById(R.id.nextButton)
        quiz_question = findViewById(R.id.Q1_text)
        quiz_heading = findViewById(R.id.Q1)


        parseData()

        nextButton.setOnClickListener {
            if(clickedButton.isEmpty()){
                Toast.makeText(this, "Select an Option!", Toast.LENGTH_SHORT).show()
            }else{
                val ans = options[idx - 1][4]
                val button = clickedButton[clickedButton.size - 1]
                if((button.text.toString()) == ans){
                    button.setBackgroundDrawable(resources.getDrawable(R.drawable.correct_ans_button))
                    score += 10;
                }else{
                    button.setBackgroundDrawable(resources.getDrawable(R.drawable.wrong_ans_button))
                }

                if(nextButton.text.toString() == "Finish"){
                    val intent = Intent(this, FinalScoreActivity::class.java)
                    intent.putExtra("SCORE", score)
                    startActivity(intent)
                    finish()
                }else{
                    idx++;

                    Handler(Looper.getMainLooper()).postDelayed({
                        parseData()
                        clickedButton = arrayListOf()
                        option3.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
                        option2.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
                        option1.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
                        option4.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
                    }, 500)
                }
            }



        }
    }


    private fun parseData(){
        if(idx == 5){
            nextButton.setText("Finish").toString()
        }else{
            nextButton.setText("Next").toString()
        }

        option1.setText(options[idx-1][0]).toString()
        option2.setText(options[idx-1][1]).toString()
        option3.setText(options[idx-1][2]).toString()
        option4.setText(options[idx-1][3]).toString()

        val res = resources.getIdentifier(images[idx-1], "drawable", this.packageName)
        quizImageView.setImageResource(res)

        quiz_heading.setText("Question - $idx").toString()

        quiz_question.setText(questions[idx - 1]).toString()
    }

    fun onTapOption(view: View) {
        val button = view as AppCompatButton
        clickedButton.add(button)
        when(button.tag.toString().toInt()){
            1 -> {
                option1.setBackgroundDrawable(resources.getDrawable(R.drawable.select_button))
                option2.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
                option3.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
                option4.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
            }

            2 -> {option2.setBackgroundDrawable(resources.getDrawable(R.drawable.select_button))
                option1.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
                option3.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
                option4.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
            }
            3 -> {option3.setBackgroundDrawable(resources.getDrawable(R.drawable.select_button))
                option2.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
                option1.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
                option4.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
            }
            4 -> {option4.setBackgroundDrawable(resources.getDrawable(R.drawable.select_button))
                option2.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
                option3.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
                option1.setBackgroundDrawable(resources.getDrawable(R.drawable.quiz_button))
            }
        }
    }

    fun goBack(view: View) {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
        finish()
    }
}