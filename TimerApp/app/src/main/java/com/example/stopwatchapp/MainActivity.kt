package com.example.stopwatchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private var time = 0
    private var timerTask: Timer? = null

    lateinit var timeString: String

    lateinit var secTextView: TextView
    lateinit var milliTextView: TextView
    lateinit var timerSetButton: Button
    lateinit var secEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        secTextView = findViewById<TextView>(R.id.secTextView)
        milliTextView = findViewById<TextView>(R.id.milliTextView)
        timerSetButton = findViewById<Button>(R.id.timerSetButton)
        secEditText = findViewById<EditText>(R.id.secEditText)

        timerSetButton.setOnClickListener {
            start()
        }
    }

    private fun start(){
        // 시간 입력 - 값이 반드시 있어야 함 (null 허용 안함)
        timeString = secEditText.text!!.toString()
        time = Integer.parseInt(timeString) * 100

        timerTask = timer(period=10){
            // 시간이 줄어들어야 함
            val sec = time/100
            val milli = time%100

            if(time==0){
                timerTask?.cancel()
            }

            time--

            runOnUiThread{
                secTextView.text = "$sec"
                milliTextView.text = "$milli"
            }
        }
    }
}