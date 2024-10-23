package com.example.aidify.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aidify.ui.components.LibraryCard
import com.example.aidify.ui.components.ModalCardDetails
import com.example.aidify.viewmodels.EducationalLibraryViewModel

@Composable
fun EducationalLibraryScreen(viewModel: EducationalLibraryViewModel) {
    val cardList by viewModel.cardList.collectAsState()
    val isModalOpen by viewModel.isModalOpen.collectAsState()
    val selectedCard by viewModel.selectedCard.collectAsState()

    if (isModalOpen) {
        selectedCard?.let { card ->
            ModalCardDetails(card = card, onClose = { viewModel.closeModal() })
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(cardList.size) { card ->
            LibraryCard(
                title = cardList[card].title,
                mediaType = cardList[card].mediaType,
                category = cardList[card].category,
                modifier = Modifier.clickable {
                    viewModel.selectCard(cardList[card])
                }
            )
        }
    }
}
