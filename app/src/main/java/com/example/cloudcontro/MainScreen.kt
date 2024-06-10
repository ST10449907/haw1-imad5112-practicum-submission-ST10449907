package com.example.cloudcontro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainScreen : AppCompatActivity() {

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


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        // Edit text and Text view declaration:
        val inputDay = findViewById<EditText>(R.id.txtInput)                                        //(IIE, 2024)
        val txtDisplay = findViewById<TextView>(R.id.txtOutput)                                     //(IIE, 2024)

        //All buttons / text views/ edit texts and logo's are declared here:
        //This is the declaration of the button exits the app after it is clicked.
        val exitApp = findViewById<Button>(R.id.btnExit)                                            //(IIE, 2024)

        //this is the declaration of the button clears any text that is within the text view and the edit text
        val clearText = findViewById<Button>(R.id.btnClear)                                         //(IIE, 2024)

        //this is the declaration of the button that displays the average temperature after is clicked  //(IIE, 2024)
        val averageDisplay = findViewById<Button>(R.id.btnAverage)

        //for safety and error handling, i declared the logo(image) to be safe..
        val logo = findViewById<ImageView>(R.id.imgLogo) //This is the image(Logo)                  //(IIE, 2024)

        //this is the declaration of the button that will take us to the next page:
        val displayDetail = findViewById<Button>(R.id.btnDisplayDetails)                            //(IIE, 2024)

        //this button will display the average temp after being clicked.
        val displayTemp = findViewById<Button>(R.id.btnTemp)                                        //(IIE, 2024)


        displayDetail.setOnClickListener {
            val intent = Intent(this, DetailedScreen::class.java)
            startActivity(intent) //this will take us to the next page, which is the detail page    //(IIE, 2024) - page 64
        }

        clearText.setOnClickListener {//this clears any text that is within the text view and edit text,
            inputDay.text.clear()
            txtDisplay.text = ""                                                                    //(OpenAi, 2024)
        }

        exitApp.setOnClickListener {
            finishAffinity() //this will close the app after is it clicked by the user.             //(Github, 2024) , (OpenAi, 2024) - i had this written on my first assignment.
        }

        // This button displays a summary of the temperature of that day
        displayTemp.setOnClickListener {
            val enteredDay = inputDay.text.toString().trim()                                        //(openAi, 2024)
            var index = 0
            var found = false
            while (index < daysOfWeek.size && !found) { //while loop is used
                if (daysOfWeek[index] == enteredDay) {
                    found = true
                    txtDisplay.text = "For $enteredDay, the temperature is: ${weatherCondition[index]}."
                }
                index++ //initialisation just as explained in class                                 //(IIE, 2024)
            }

            //Error Management
                if (!found) { //if NOT found display the message
                    txtDisplay.text = "You have entered an incorrect day of the week(eg. Monday)." //(IIE, 2024)
            }
        }

        //this button calculates the average temperature of that day using a while loop
        averageDisplay.setOnClickListener {                                                  //IIE, 2024
            var sum = 0
            var i = 0
            while (i < daysOfWeek.size) {
                sum += (highTemp[i] + lowTemp[i]) / 2
                i++ //initialisation
            }
            val average = sum / daysOfWeek.size
            txtDisplay.text = "The average temperature for all days of the week is: $average°C."    //(IIE, 2024)
        }
    }
}


/* Reference list:
- IIE. (2024).INTRODUCTION TO MOBILE APPLICATION DEVELOPMENT
- OpenAi. (2024). ChatGPT
 */
