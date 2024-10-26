package com.example.aidify.viewmodels

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.example.aidify.models.EducationalLibraryCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.aidify.assets.cardsData
import kotlin.math.log

class EducationalLibraryViewModel : ViewModel() {
    private val _cardList = MutableStateFlow<List<EducationalLibraryCard>>(emptyList())
    val cardList: StateFlow<List<EducationalLibraryCard>> = _cardList

    private val _selectedCard = MutableStateFlow<EducationalLibraryCard?>(null)
    val selectedCard: StateFlow<EducationalLibraryCard?> = _selectedCard

    private val _isModalOpen = MutableStateFlow(false)
    val isModalOpen: StateFlow<Boolean> = _isModalOpen

    private val _currentTab = MutableStateFlow(0)
    val currentTab: StateFlow<Int> = _currentTab

    init {
        loadCardsContent()
    }

    private fun loadCardsContent() {
        _cardList.value = cardsData.cards
    }

    fun selectCard(card: EducationalLibraryCard) {
        _selectedCard.value = card
        _isModalOpen.value = true
    }

    fun closeModal() {
        _isModalOpen.value = false
    }

    fun switchTab(i: Int) {
        _currentTab.value = i
    }
}