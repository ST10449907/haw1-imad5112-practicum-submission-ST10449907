package com.example.cloudcontro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailedScreen : AppCompatActivity() {

    // Parallel array of the day of the week, Max & Min Temperature and average temperature:
    var daysOfWeek = arrayOf(                                                                       //(IIE, 2024)
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday"
    )

    // Array showing The weather conditions:
    var weatherCondition = arrayOf(                                                                 //(IIE, 2024)
        "Partly Cloudy. High: 27°c / Low: 22°c",
        "Sunny. High: 32°c / Low: 28°c",
        "Cloudy. High: 19°c / Low: 15°c",
        "Rainy. High: 15°c / Low: 10°c",
        "Cloudy. High: 22°c / Low: 18°c",
        "Partly Cloudy. High: 25°c / Low: 21°c",
        "Sunny. High: 30°c / Low: 27°c"
    )

    //Parallel array containing the high and low temperatures:
    var highTemp = arrayOf(                                                                         //(IIE, 2024)
        27,
        32,
        19,
        15,
        22,
        25,
        30
    )
    var lowTemp = arrayOf(                                                                          //(IIE, 2024)
        22,
        28,
        15,
        10,
        18,
        21,
        27
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_screen)

        //declarations for all buttons, edit texts and text view
        val logo = findViewById<ImageView>(R.id.logo) //declaration of logo for error handling      //(IIE, 2024)

        val txtOutput = findViewById<TextView>(R.id.txtView)                                        //(IIE, 2024)
        val returnButton = findViewById<Button>(R.id.btnReturnMain)                                 //(IIE, 2024)
        val displayButton = findViewById<Button>(R.id.btnDisplayScreen)                             //(IIE, 2024)

        //This is the button that allows the user to return to main page
        returnButton.setOnClickListener {                                                    //(IIE, 2024)
            val intent = Intent(this, MainScreen::class.java)                          //(IIE, 2024)
            startActivity(intent)                                                                   //(IIE, 2024)
        }

        displayButton.setOnClickListener {                                                   //(IIE, 2024)
            val intent = intent

            val builder = StringBuilder()                                                           //Openai,2024

            for (i in daysOfWeek.indices) {
                val displayText = "Day: ${daysOfWeek[i]}\n" +                                       //(openAi, 2024)
                        "Weather Condition: ${weatherCondition[i]}\n" +
                        "High Temperature: ${highTemp[i]}°C\n" +
                        "Low Temperature: ${lowTemp[i]}°C\n\n"
                builder.append(displayText)
            }

            txtOutput.text = builder.toString()                                                     //(openAi.2024)
        }
    }
}

/* Reference list:
- IIE. (2024).INTRODUCTION TO MOBILE APPLICATION DEVELOPMENT
- OpenAi. (2024). ChatGPT
 */
