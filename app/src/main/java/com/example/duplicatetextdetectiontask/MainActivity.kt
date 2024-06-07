package com.example.duplicatetextdetectiontask


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// Main activity class to handle the user interface and interaction
class MainActivity : AppCompatActivity() {

    // Declare variables for text processor and UI components
    private lateinit var textProcessor: TextProcessor
    private lateinit var text1: EditText
    private lateinit var text2: EditText
    private lateinit var compareButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the text processor
        textProcessor = TextProcessor()

        // Initialize the UI components
        initializeUI()

        // Set up the click listener for the compare button
        compareButton.setOnClickListener {
            compareTexts()
        }
    }

    // Function to initialize UI components
    private fun initializeUI() {
        text1 = findViewById(R.id.text1)
        text2 = findViewById(R.id.text2)
        compareButton = findViewById(R.id.compare_button)
        resultText = findViewById(R.id.result_text)
    }

    // Function to compare texts and display the result
    private fun compareTexts() {
        val inputText1 = text1.text.toString()
        val inputText2 = text2.text.toString()
        val isDuplicate = textProcessor.areTextsDuplicates(inputText1, inputText2)

        resultText.visibility = TextView.VISIBLE
        resultText.text = if (isDuplicate) {
            "The texts are duplicates."
        } else {
            "The texts are not duplicates."
        }
    }
}