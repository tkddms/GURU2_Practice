package com.example.checkboxapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CheckedTextView
import android.widget.CompoundButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var checkApple: CheckBox
    lateinit var checkOrange: CheckBox
    lateinit var checkBanana: CheckBox
    
    var listener = CompoundButton.OnCheckedChangeListener{ compoundButton, isChecked ->
        if (isChecked){
            when(compoundButton.id){
                R.id.checkApple -> Toast.makeText(applicationContext, "사과", Toast.LENGTH_SHORT).show()
                R.id.checkOrange -> Toast.makeText(applicationContext, "오렌지", Toast.LENGTH_SHORT).show()
                R.id.checkBanana -> Toast.makeText(applicationContext, "바나나", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkApple = findViewById(R.id.checkApple)
        checkOrange = findViewById(R.id.checkOrange)
        checkBanana = findViewById(R.id.checkBanana)

        checkApple.setOnCheckedChangeListener(listener)
        checkOrange.setOnCheckedChangeListener(listener)
        checkBanana.setOnCheckedChangeListener(listener)

    }
}