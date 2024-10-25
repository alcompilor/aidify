package com.example.aidify.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aidify.models.CardCategory
import com.example.aidify.models.EducationalLibraryCard

@Composable
fun LibrarySection(cardList: List<EducationalLibraryCard>, onCardSelected: (EducationalLibraryCard) -> Unit, category: CardCategory) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(cardList.size) { index ->
            val card = cardList[index]
            if (card.category == category) {
                LibraryCard(
                    title = card.title,
                    mediaType = card.mediaType,
                    modifier = Modifier.clickable { onCardSelected(card) }
                )
            }
        }
    }
}