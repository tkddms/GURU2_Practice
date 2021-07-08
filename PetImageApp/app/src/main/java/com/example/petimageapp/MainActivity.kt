package com.example.petimageapp

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var chkAgree: CheckBox
    lateinit var rdoGroup: RadioGroup
    lateinit var rdoDog: RadioButton
    lateinit var rdoCat: RadioButton
    lateinit var rdoRabbit: RadioButton
    lateinit var button: Button
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "애완동물 사진 보기"

        textView = findViewById(R.id.textView2)
        chkAgree = findViewById(R.id.startCheck)
        rdoGroup = findViewById(R.id.petRadioGroup)
        rdoDog = findViewById(R.id.dog)
        rdoCat = findViewById(R.id.cat)
        rdoRabbit = findViewById(R.id.rabbit)
        button = findViewById(R.id.selectBtn)
        imageView = findViewById(R.id.printImage)

        chkAgree.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                rdoGroup.visibility = View.VISIBLE
                textView.visibility = View.VISIBLE
                button.visibility = View.VISIBLE
            }else{
                rdoGroup.visibility = View.INVISIBLE
                textView.visibility = View.INVISIBLE
                button.visibility = View.INVISIBLE

            }
        }

        button.setOnClickListener {
            when(rdoGroup.checkedRadioButtonId){
                R.id.dog -> imageView.setImageResource(R.drawable.dog)
                R.id.cat -> imageView.setImageResource(R.drawable.cat)
                R.id.rabbit -> imageView.setImageResource(R.drawable.rabbit)
                else -> Toast.makeText(applicationContext, "동물을 먼저 선택하세요.", Toast.LENGTH_SHORT).show()
            }
            imageView.visibility = View.VISIBLE
        }
    }
}