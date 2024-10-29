package com.example.imahistorian

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.imahistorian.R.*

class FourthActivity : AppCompatActivity() {

    private lateinit var allCountTV: TextView
    private lateinit var answer1RB: RadioButton
    private lateinit var answer2RB: RadioButton
    private lateinit var answer3RB: RadioButton
    private lateinit var answerBTN: Button
    private lateinit var nextBTN: Button
    private lateinit var checkAnswerTV: TextView
    private var sumValue = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_fourth)

        allCountTV = findViewById(R.id.allCountTV)
        answer1RB = findViewById(R.id.answer1RB)
        answer2RB = findViewById(R.id.answer2RB)
        answer3RB = findViewById(R.id.answer3RB)
        answerBTN = findViewById(R.id.answerBTN)
        nextBTN = findViewById(R.id.nextBTN)
        checkAnswerTV = findViewById(R.id.checkAnswerTV)

        nextBTN.isEnabled = false

        val argument = intent.getIntExtra("sumVal",0)
        allCountTV.text = "Всего набрано балов - $argument"

        answerBTN.setOnClickListener {
            if(answer1RB.isChecked){
                checkAnswerTV.text = "Это правильный ответ.\nВы заработали 100 балов"
                checkAnswerTV.setTextColor(Color.parseColor("#DE293E03"))
                sumValue = 100
            } else {
                checkAnswerTV.text = "Это не правильный ответ.\nВы заработали 0 балов " +
                        "\nПравильный вариан - перед Куликовской битвой"
                checkAnswerTV.setTextColor(Color.parseColor("#DE6B1C09"))
            }
            answerBTN.isEnabled = false
            allCountTV.text = "Всего набрано балов - ${sumValue + argument}"
            nextBTN.isEnabled = true
        }

        nextBTN.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            intent.putExtra("sumVal", sumValue  + argument)
            startActivity(intent)
        }

    }
}