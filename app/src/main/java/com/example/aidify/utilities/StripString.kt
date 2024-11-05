package com.example.aidify.utilities

fun stripSpecialCharacters(text: String): String {
    return text.replace(Regex("[^a-zA-Z0-9\\s.,!?;:'\"-]"), "")
}