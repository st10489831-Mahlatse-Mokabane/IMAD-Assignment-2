package vcmsa.ci.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess


class MainEvaluate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_evaluate)

        //Code attribution for linking elements by their id
        //This method was taken from the
        //IMAD5112 Module Manual 2025
        //Page 41

        // Linking elements by their ID'S
        val evaluationTxt = findViewById<TextView>(R.id.evaluationTxt)
        val restartBtn = findViewById<Button>(R.id.restartBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)

        // Gets the questions and answers passed from the Main Points activity
        val questions = intent.getShortArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val evaluation = StringBuilder()

        //Code attribution for logical operators
        //This method was taken from the
        //IMAD5112 Module Manual 2025
        //Page 52

        if (questions != null && answers != null && questions.size == answers.size) {
            for (i in questions.indices) {

                //Code attribution to represent a new line and leave one line open
                //This method was taken from the
                //IMAD5112 Module Manual 2025
                //Page 67

                evaluationTxt.append("${i + 1}. ${questions[i]}\n")
                evaluationTxt.append("  Answer: ${if (answers[i]) "True" else "False"}\n\n")
            }
            evaluationTxt.text = evaluationTxt.toString()
        } else {
            evaluationTxt.text =  "Failed to retrieve evaluation data."
        }

        // Create a click listener for the restart button
        restartBtn.setOnClickListener {

            //Code attribution to start activity
            //This method was taken from the
            //IMAD5112 Module Manual 2025
            //Page 64

            startActivity(Intent(this, MainQuiz::class.java))
        }

        // Create a click listener for the exit button
        exitBtn.setOnClickListener {
            finishAffinity()
            exitProcess(0) //Terminate the app
        }
    }
}