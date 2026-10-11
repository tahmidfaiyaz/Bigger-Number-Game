package com.example.biggernumbergame3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.Toast
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var number1 = 0
    private var number2 = 0
    private var score = 0

    private lateinit var number1Text: Button
    private lateinit var number2Text: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        val scoreText = findViewById<TextView>(R.id.scoreText)
        number1Text = findViewById(R.id.number1Text)
        number2Text = findViewById(R.id.number2Text)

        generateNumbers()



        number1Text.setOnClickListener {
            if (number1 > number2) {
                score = score + 1
                scoreText.text = "Points: $score"
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()


            }  else if(number1 < number2) {
                score = score - 1
                scoreText.text = "Points: $score"
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
            }


            else {
                Toast.makeText(this, "Draw !", Toast.LENGTH_SHORT).show()
            }




            generateNumbers()
        }

        number2Text.setOnClickListener {
            if (number2 > number1) {
                score = score + 1
                scoreText.text = "Points: $score"
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()

            } else if(number2 < number1){
                score = score - 1
                scoreText.text = "Points: $score"
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
            }


            else {
                Toast.makeText(this, "Draw !", Toast.LENGTH_SHORT).show()
            }
            generateNumbers()
        }

        number1Text.text = number1.toString()
        number2Text.text = number2.toString()



    }

    private fun generateNumbers() {
        number1 = (1..100).random()
        number2 = (1..100).random()

        number1Text.text = number1.toString()
        number2Text.text = number2.toString()
    }

}