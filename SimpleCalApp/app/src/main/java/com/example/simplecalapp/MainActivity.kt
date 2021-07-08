package com.example.simplecalapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var edit1: EditText  ; lateinit var edit2: EditText
    lateinit var addBtn: Button ; lateinit var subBtn: Button
    lateinit var mulBtn: Button ; lateinit var divBtn: Button
    lateinit var resultText: TextView
    lateinit var num1: String ; lateinit var num2: String
    var result: Int?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "초간단 계산기"

        edit1 = findViewById(R.id.edit1)
        edit2 = findViewById(R.id.edit2)
        addBtn = findViewById(R.id.addBtn)
        subBtn = findViewById(R.id.subBtn)
        mulBtn = findViewById(R.id.mulBtn)
        divBtn = findViewById(R.id.divBtn)
        resultText = findViewById(R.id.resultText)

        addBtn.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) + Integer.parseInt(num2)
            resultText.text = "계산 결과 : " + result.toString()
            false
        }

        subBtn.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) - Integer.parseInt(num2)
            resultText.text = "계산 결과 : " + result.toString()
            false
        }

        mulBtn.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) * Integer.parseInt(num2)
            resultText.text = "계산 결과 : " + result.toString()
            false
        }

        divBtn.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) / Integer.parseInt(num2)
            resultText.text = "계산 결과 : " + result.toString()
            false
        }


    }
}