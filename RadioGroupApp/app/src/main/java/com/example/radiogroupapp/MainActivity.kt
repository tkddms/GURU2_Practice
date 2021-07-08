package com.example.radiogroupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var radioGroup: RadioGroup
    lateinit var radioApple: RadioButton
    lateinit var radioOrange: RadioButton
    lateinit var radioBanana: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radioGroup1)
        radioApple = findViewById(R.id.radioApple)
        radioBanana = findViewById(R.id.radioBanana)
        radioOrange = findViewById(R.id.radioOrange)

        radioGroup.setOnCheckedChangeListener { radioGroup, checkedId ->
            when(checkedId){
                R.id.radioApple -> Toast.makeText(applicationContext, "사과", Toast.LENGTH_SHORT).show()
                R.id.radioBanana -> Toast.makeText(applicationContext, "바나나", Toast.LENGTH_SHORT).show()
                R.id.radioOrange -> Toast.makeText(applicationContext, "오렌지", Toast.LENGTH_SHORT).show()
            }
        }
    }
}