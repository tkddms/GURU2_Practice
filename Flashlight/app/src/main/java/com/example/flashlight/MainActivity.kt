package com.example.flashlight

import android.graphics.SweepGradient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch

class MainActivity : AppCompatActivity() {

    lateinit var flashSwitch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flashSwitch = findViewById(R.id.flashSwitch)
        val torch = Torch(this)

        flashSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                torch.flashOn()
            }else{
                torch.flashOff()
            }
        }
    }
}