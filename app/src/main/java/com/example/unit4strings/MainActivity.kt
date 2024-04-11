package com.example.unit4strings

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var addButton: Button
    private lateinit var compareButton: Button
    private lateinit var vowelCountButton: Button

    private lateinit var resultView: TextView
    private lateinit var string1: EditText
    private lateinit var string2: EditText

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        addButton = findViewById(R.id.add_btn)
        compareButton = findViewById(R.id.compare_btn)
        vowelCountButton = findViewById(R.id.vowel_cnt_btn)
        resultView = findViewById(R.id.result)
        string1 = findViewById(R.id.string1)
        string2 = findViewById(R.id.string2)

        addButton.setOnClickListener {
            //resultView.text = string1.getText().toString() + " " + string2.getText().toString()
            setResultField(addStrings())
        }

        compareButton.setOnClickListener {
            setResultField(compareStrings())
        }

        vowelCountButton.setOnClickListener {
            setResultField(countVowels())
        }
    }

    private fun setResultField(data: String) {
        resultView.text = data.toString()
    }

    private fun getValueOne(): String {
        return string1.getText().toString()
    }

    private fun getValueTwo(): String {
        return string2.getText().toString()

    }

    private fun addStrings(): String {
        val val1 = getValueOne()
        val val2 = getValueTwo()
        return val1 + " " + val2
    }

    private fun compareStrings(): String {
        val val1 = getValueOne()
        val val2 = getValueTwo()
        return if (val1 == val2) {
            "Matching"
        } else {
            "Not Matching"
        }
    }

    private fun countVowels(): Int {
        val val1 = getValueOne()
        val val2 = getValueTwo()
        //create one string from the two input strings
        val s = val1 + val2
        //iterate over every character in the string
        val count = 0
        for (int i=0; i<s.length; i++) run {
            val c: Char = s.charAt(i)
            //if a character is a vowel, add 1 to a count variable
            if (c == 'a' || c == 'i' || c == 'o' || c == 'e' || c == 'u') {
                count += 1
            }

            return count
        }
    }
}