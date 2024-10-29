package com.example.imahistorian

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var startVictorinBTN: Button
    private lateinit var toolbar: Toolbar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        startVictorinBTN = findViewById(R.id.startVictorin)
        toolbar = findViewById(R.id.toolbarTB)

        startVictorinBTN.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
//            intent.putExtra("resultCalc", resultCalc.toString())
//            setResult(RESULT_OK, intent)
        }

        setSupportActionBar(toolbar)
        title = "Исторческая викторина\n\n История РОССИИ"
//        startVictorinBTN.setEnabled(false)



    }
}