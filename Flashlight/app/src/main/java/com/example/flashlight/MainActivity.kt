 package com.example.flashlight

import android.content.Intent
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
        val intent = Intent(this, TorchService::class.java)

        flashSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                intent.action = "on"
                startService(intent)
            }else{
                intent.action = "off"
                startService(intent)
            }
        }
    }
}