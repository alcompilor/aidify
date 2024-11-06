package com.example.aidify.models

data class EducationalLibraryCard(
    val title: String,
    val description: String,
    val link: String,
    val mediaType: CardMediaType,
    val category: CardCategory
)

enum class CardCategory {
    ALCOHOL, SUBSTANCE
}

enum class CardMediaType {
    ARTICLE, VIDEO
}