package tn.esprit.colormixer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tn.esprit.colormixer.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    // TODO 18: Add lateinit var for binding
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO 19: Bind the view and implement setContentView()
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO 20: Check the RESULT from the intent and change rlBackground BackgroundColor / btnQuit BackgroundColor / imgResult / txtResult / txtName / txtAnswer
        val result = intent.getStringExtra(RESULT)
        if (result == SUCCESS) {
            // Set the background color, image, and text for success
            binding.rlBackground.setBackgroundColor(/* set the color for success */)
            binding.imgResult.setImageResource(/* set the image for success */)
            binding.txtResult.text = "Success"
        } else if (result == FAILED) {
            // Set the background color, image, and text for failure
            binding.rlBackground.setBackgroundColor(/* set the color for failure */)
            binding.imgResult.setImageResource(/* set the image for failure */)
            binding.txtResult.text = "Failed"
        }

        val name = intent.getStringExtra(NAME)
        binding.txtName.text = name

        val answer = intent.getStringExtra(MIXED_COLOR)
        binding.txtAnswer.text = answer

        // TODO 21: Implement setOnClickListener for btnQuit to destroy the activity
        binding.btnQuit.setOnClickListener {
            finish()
        }
    }
}
