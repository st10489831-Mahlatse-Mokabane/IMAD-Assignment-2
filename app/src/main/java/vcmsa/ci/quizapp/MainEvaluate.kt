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


        val evaluationTxt = findViewById<TextView>(R.id.evaluationTxt)
        val restartBtn = findViewById<Button>(R.id.restartBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)

        // Gets the questions and answers passed from the Main Points activity
        val questions = intent.getShortArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val evaluation = StringBuilder()
        if (questions != null && answers != null && questions.size == answers.size) {
            for (i in questions.indices) {
                evaluationTxt.append("${i + 1}. ${questions[i]}\n")
                evaluationTxt.append("  Answer: ${if (answers[i]) "True" else "False"}\n\n")
            }
            evaluationTxt.text = evaluationTxt.toString()
        } else {
            evaluationTxt.text =  "Failed to retrieve evaluation data."
        }

        restartBtn.setOnClickListener {
            startActivity(Intent(this, MainQuiz::class.java))
        }
        exitBtn.setOnClickListener {
            finishAffinity()
            exitProcess(0) //Ternimate the app
        }
    }
}