package vcmsa.ci.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainPoints : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_points)

        val messageTxt = findViewById<TextView>(R.id.messageTxt)
        val totalPointsTxt = findViewById<TextView>(R.id.totalPointsTxt)
        val observeTxt = findViewById<TextView>(R.id.observeTxt)
        val evaluateBtn = findViewById<Button>(R.id.evaluateBtn)
        val closeBtn = findViewById<Button>(R.id.closeBtn)

        messageTxt.text = "Total points earned:"

        val points = intent.getIntExtra("points", 0)
        totalPointsTxt.text = "Your Points: $points/5"

        val observe = if (points >= 3) {
            "Outstanding Performance!"
        } else {
            "Don't give up, practice makes perfect!"
        }
        observeTxt.text = observe

        // Create a click listener for the evaluate button
        evaluateBtn.setOnClickListener{
            // Starts the evaluate activity and pass the questions and answers
            val intent = Intent(this, MainEvaluate::class.java)
            intent.putExtra("questions", MainQuiz.questions)
            intent.putExtra("answers", MainQuiz.answers) 
            startActivity(intent)
        }

        // Create an click listener for the close button
        closeBtn.setOnClickListener {
            finish() // Closes the app
        }
    }
}