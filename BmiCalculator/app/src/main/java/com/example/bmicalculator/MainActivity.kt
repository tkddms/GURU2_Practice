package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var resultButton: Button   // resultActivity로 이동하도록 하는 Btn
    // 키, 몸무게 값 전달
    lateinit var heightEditText: EditText
    lateinit var weightEditText: EditText
    lateinit var nameEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // setting
        resultButton = findViewById<Button>(R.id.resultButton)
        heightEditText = findViewById<EditText>(R.id.heightEditText)
        weightEditText = findViewById<EditText>(R.id.weightEditText)
        nameEditText = findViewById<EditText>(R.id.nameEditText)
        loadData()  // 기존 값 로드

        resultButton.setOnClickListener {
            saveData(heightEditText.text.toString().toInt(), weightEditText.text.toString().toInt())
            // intent 전환
            var intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("name", nameEditText.text.toString())
            intent.putExtra("height", heightEditText.text.toString())
            intent.putExtra("weight", weightEditText.text.toString())
            startActivity(intent)
        }
    }

    // 데이터 저장하기
    private fun saveData(height: Int, weight: Int){
        var pref = this.getPreferences(0)
        var editor = pref.edit()    // 공유 변수 file에 write

        editor.putInt("KEY_HEIGHT", heightEditText.text.toString().toInt()).apply()
        editor.putInt("KEY_WEIGHT", weightEditText.text.toString().toInt()).apply()
        editor.putString("KEY_NAME", nameEditText.text.toString()).apply()
    }

    // 데이터 불러오기
    private fun loadData(){
        var pref = this.getPreferences(0)
        var height = pref.getInt("KEY_HEIGHT", 0)
        var weight = pref.getInt("KEY_WEIGHT", 0)
        var name = pref.getString("KEY_NAME", "")
        // height or weight가 0일때 -> 아래 코드 실행 안함.
        if(height != 0 && weight != 0){
            nameEditText.setText(name.toString())
            heightEditText.setText(height.toString())
            weightEditText.setText(weight.toString())
        }
    }
}