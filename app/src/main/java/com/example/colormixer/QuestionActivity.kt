package tn.esprit.colormixer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// TODO 2: Add string constant val here for RED / BLUE / YELLOW / PURPLE / GREEN / ORANGE
const val RED = "Red"
const val BLUE = "Blue"
const val YELLOW = "Yellow"
const val PURPLE = "Purple"
const val GREEN = "Green"
const val ORANGE = "Orange"

// TODO 3: Add string constant val here for NAME / MIXED_COLOR / COLOR1 / COLOR2 / RESULT / SUCCESS / FAILED
const val NAME = "Name"
const val MIXED_COLOR = "MixedColor"
const val COLOR1 = "Color1"
const val COLOR2 = "Color2"
const val RESULT = "Result"
const val SUCCESS = "Success"
const val FAILED = "Failed"

class QuestionActivity : AppCompatActivity() {

    // TODO 4: Add lateinit var for binding
    private lateinit var binding: ActivityQuestionBinding

    enum class ActivityQuestionBinding {

    }

    // TODO 5: Add var for colorMixed / color1 / color2 / name
    private var colorMixed: String = ""
    private var color1: String = ""
    private var color2: String = ""
    private var name: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO 6: Bind the view and implement setContentView()
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO 7: Implement setOnClickListener on the button Mix and call mixColor()
        binding.btnMix.setOnClickListener {
            mixColor()
        }
    }

    private fun mixColor() {
        // TODO 8: Check if the input for FullName. IF it's empty show a snackbar with the message: You must enter your name!
        val fullName = binding.editTextFullName.text.toString()
        if (fullName.isEmpty()) {
            // Show a Snackbar with the message
            // You must enter your name!
        } else {
            // TODO 9: Check if Only 2 colors are selected then change the value of colorMixed / color1 / color2
            // You should check which color options are selected and set the corresponding values.

            // TODO 10: Change the value of name with the input
            name = fullName

            // TODO 11: Create an Intent to AnswerActivity and add all of the values name / colorMixed / color1 / color2. Then start the Activity.
            val intent = Intent(this, AnswerActivity::class.java)
            intent.putExtra(NAME, name)
            intent.putExtra(MIXED_COLOR, colorMixed)
            intent.putExtra(COLOR1, color1)
            intent.putExtra(COLOR2, color2)
            startActivity(intent)
        }
    }
}
