package com.example.duplicatetextdetectiontask


// Class to handle text processing logic
class TextProcessor {

    // Function to preprocess the text by converting to lowercase, splitting by non-word characters, and filtering out empty strings
    fun preprocessText(text: String): List<String> {
        return text.toLowerCase().split("\\W+".toRegex()).filter { it.isNotEmpty() }
    }

    // Function to check if two texts are duplicates based on their token similarity
    fun areTextsDuplicates(text1: String, text2: String): Boolean {
        val tokens1 = preprocessText(text1)
        val tokens2 = preprocessText(text2)
        val commonTokens = tokens1.intersect(tokens2)
        val similarityRatio = commonTokens.size.toDouble() / minOf(tokens1.size, tokens2.size)
        return similarityRatio > 0.8 // You can adjust the threshold as needed
    }
}
