package com.example.textviewapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tv1: TextView = findViewById(R.id.textView1)
        var tv2: TextView = findViewById(R.id.textView2)
        var tv3: TextView = findViewById(R.id.textView3)

        tv1.setText("화랑비록 류메이 돌아와")
        tv1.setTextColor(Color.MAGENTA)
        tv2.setTextSize(30.0f)
        tv2.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC)
        tv3.text = "류메이 돌아와 제발 당신의 화랑비록 보고 싶어 제발 여기서 끝낼 수 없잖아 류메이 쓰고 있다고 믿어 나 진짜 단행본에 종이책 다살거야 돌아오기만 해"
        tv3.setSingleLine()
    }
}