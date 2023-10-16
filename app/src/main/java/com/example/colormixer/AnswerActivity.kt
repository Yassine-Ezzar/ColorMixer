package tn.esprit.colormixer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AnswerActivity : AppCompatActivity() {

    // TODO 12: Add lateinit var for binding
    private lateinit var binding: ActivityAnswerBinding

    annotation class ActivityAnswerBinding

    private var correctColor = "NONE"
    private var name = "NONE"
    private var color1 = "NONE"
    private var color2 = "NONE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO 13: Bind the view and implement setContentView()
        binding = ActivityAnswerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO 14: Change the value of correctColor / name / color1 / color2 with the DATA from the INTENT
        correctColor = intent.getStringExtra("CORRECT_COLOR") ?: "NONE"
        name = intent.getStringExtra("NAME") ?: "NONE"
        color1 = intent.getStringExtra("COLOR1") ?: "NONE"
        color2 = intent.getStringExtra("COLOR2") ?: "NONE"

        // TODO 15: Change the txtChoosed with: "You chose $color1 and $color2"
        binding.txtChoosed.text = "You chose $color1 and $color2"

        // TODO 16: Implement setOnClickListener on the btnSubmit and call checkAnswer()
        // You must check if only one radio button is selected then navigate to the ResultActivity with the data name and RESULT (FAILED/SUCCESS)
        binding.btnSubmit.setOnClickListener {
            val result = checkAnswer()
            if (result) {
                // Correct answer
                // Navigate to ResultActivity with a success result
            } else {
                // Incorrect answer
                // Navigate to ResultActivity with a failure result
            }
        }
    }

    private fun checkAnswer(): Boolean {
        // TODO 17: Check if the answer of the chosen color is correct
        val selectedAnswerId = binding.radioGroup.checkedRadioButtonId

        if (selectedAnswerId != -1) {
            val selectedRadioButton = findViewById<RadioButton>(selectedAnswerId)
            val selectedAnswer = selectedRadioButton.text.toString()

            // Compare the selected answer with correctColor
            val isCorrect = selectedAnswer == correctColor

            if (isCorrect) {
                // Correct answer
                // Navigate to ResultActivity with a success result
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(NAME, name)
                intent.putExtra(RESULT, SUCCESS)
                startActivity(intent)
            } else {
                // Incorrect answer
                // Navigate to ResultActivity with a failure result
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(NAME, name)
                intent.putExtra(RESULT, FAILED)
                startActivity(intent)
            }

            return isCorrect
        }

        // No answer selected
        return false
    }

}
