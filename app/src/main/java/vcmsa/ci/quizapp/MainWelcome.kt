package vcmsa.ci.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainWelcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        //Code attribution for linking elements by their id
        //This method was taken from the
        //IMAD5112 Module Manual 2025
        //Page 41

        // Linking elements by their ID's
        val welcomeTxt = findViewById<TextView>(R.id.welcomeTxt)
        val descriptionTxt = findViewById<TextView>(R.id.descriptionTxt)
        val goBtn = findViewById<Button>(R.id.goBtn)
        val stopBtn = findViewById<Button>(R.id.stopBtn)

        // Write an app introduction and description
        welcomeTxt.text = "Welcome to the history Quiz!!"
        descriptionTxt.text = "Know it or guess it, true or false awaits!"

        // Create a click listener for the go button
        goBtn.setOnClickListener {

            //Code attribution to start activity
            //This method was taken from the
            //IMAD5112 Module Manual 2025
            //Page 64

            // Start the MainQuiz activity
            val  intent = Intent(this, MainQuiz::class.java)
            startActivity(intent)

            //Code attribution for what happens when a button is clicked
            //This method was taken from the
            //IMAD5112 Module Manual 2025
            //Page 43
            Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show()
        }

        // Create a click listener for the stop button
        stopBtn.setOnClickListener {
            finish()
        }
    }
}