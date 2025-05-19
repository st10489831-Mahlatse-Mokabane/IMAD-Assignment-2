package vcmsa.ci.quizapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainQuiz : AppCompatActivity() {

    private lateinit var messageTxt: TextView
    private lateinit var questionsTxt: TextView
    private lateinit var trueBtn: Button
    private lateinit var falseBtn: Button
    private lateinit var outputTxt: TextView
    private lateinit var nextBtn: Button

    companion object {
        val questions = arrayOf(
            "The Great Pyramid of Giza was built by the Babylonians",
            "The ancient Egyptians mummified their dead to preserve for the afterlife",
            "The ancient Greeks were known for their expertise in shipbuilding",
            "The ancient city of Pompeii was destroyed by a tsunami",
            "The ancient Romans built the Great Wall of China",

            )
        val answers = booleanArrayOf(false, true, true, false, false)
    }

    //
    private var currentQuestionsIndex= 0
    private var points = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        // Initialising all elements
        messageTxt = findViewById(R.id.messageTxt)
        questionsTxt = findViewById(R.id.questionsTxt)
        trueBtn = findViewById(R.id.trueBtn)
        falseBtn = findViewById(R.id.falseBtn)
        outputTxt = findViewById(R.id.outputTxt)
        nextBtn = findViewById(R.id.nextBtn)

        // Display the first question
        displayQuestion()

        // Create click listeners for answer buttons
        trueBtn.setOnClickListener { checkAnswer(true) }
        falseBtn.setOnClickListener { checkAnswer(false) }

        // Create a click listener for next button
        nextBtn.setOnClickListener {
            currentQuestionsIndex++
            if (currentQuestionsIndex < questions.size) {
                displayQuestion()
                outputTxt.text = "" // Clears the output
                trueBtn.isEnabled = true //Enables buttons
                falseBtn.isEnabled = true
            } else {
                // Goes to the MainPoints activity
                val intent = Intent(this,MainPoints::class.java)
                intent.putExtra("points", points)
                startActivity(intent)
                finish() // To finish the quiz so that the user can't go back
            }
        }
        nextBtn.isEnabled = false // This disables the next button
    }

    private fun displayQuestion() {
        questionsTxt.text = questions[currentQuestionsIndex]
    }
   private fun checkAnswer(userAnswer: Boolean) {
       val correctAnswer = answers[currentQuestionsIndex]

       if (userAnswer == correctAnswer) {
           outputTxt.text = "Valid!"
           outputTxt.setTextColor(Color.GREEN)
           points++
       } else {
           outputTxt.text = "Invalid!"
           outputTxt.setTextColor(Color.RED)
       }
       trueBtn.isEnabled = false
       falseBtn.isEnabled = false
       nextBtn.isEnabled = true
   }
}