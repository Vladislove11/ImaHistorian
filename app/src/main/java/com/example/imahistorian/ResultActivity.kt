package com.example.imahistorian

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    private lateinit var allValueTV: TextView
        private lateinit var checkAnswerTV: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        allValueTV = findViewById(R.id.allValueTV)
        checkAnswerTV = findViewById(R.id.checkAnswerTV)

        val argument = intent.getIntExtra("sumVal",0)
        allValueTV.text = "Всего набрано балов - $argument"

        val textComent = when(argument){
            in 401..500 -> "У вас отличные знания по истории. Так держать!"
            in 201 .. 400 -> "У вас почти получилось! Осталось немного подятнуть знания"
            in 100 .. 200 -> "Стоит прочитать ещё пару книг по истории и у Вас всё  получиться"
            in 0 .. 99 -> "Может быть история это не Ваше)"
            else -> "Что то пошло не так!!"
        }
        checkAnswerTV.text = textComent

    }
}