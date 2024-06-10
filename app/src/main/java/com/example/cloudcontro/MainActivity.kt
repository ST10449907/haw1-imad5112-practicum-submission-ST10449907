package com.example.cloudcontro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Button Declaration:
        val getStarted = findViewById<Button>(R.id.btnGetStarted)                                   //(IIE, 2024)

        //This button enables the user to go to the next page
        getStarted.setOnClickListener {
            val intent = Intent(this,MainScreen::class.java)                           //(IIE, 2024)
            startActivity(intent)                                                                   //(IIE, 2024)

        }
    }
}

/* Reference list:
- IIE. (2024).INTRODUCTION TO MOBILE APPLICATION DEVELOPMENT
 */
