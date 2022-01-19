package com.example.biggernumber

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    val left_btn = findViewById<Button>(R.id.left_btn)
    val right_btn = findViewById<Button>(R.id.right_btn)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNumbersToButtons()
        left_btn.setOnClickListener {
            checkAnswer(true)
        }

        right_btn.setOnClickListener {
            checkAnswer(false)
        }
    }

    private fun assignNumbersToButtons() {

        val r = Random
        val leftNum = r.nextInt(10)
        var rightNum = leftNum
        while (rightNum == leftNum){
            rightNum = r.nextInt(10)
        }
        left_btn.text = leftNum.toString()
        right_btn.text = rightNum.toString()
    }

    private fun checkAnswer(isLeftButtonSelected : Boolean){
        val leftNum = left_btn.text.toString().toInt()
        val rightNum = right_btn.text.toString().toInt()
        val isAnswerCorrect = if (isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum

        if(isAnswerCorrect){
            left_btn.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "Correct",Toast.LENGTH_SHORT).show()
        }
        else{
            left_btn.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong!",Toast.LENGTH_SHORT).show()
        }
    }
}
