package com.example.aidify.viewmodels

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.aidify.models.ParticipantData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PilViewModel(private val _state: MutableState<ParticipantData>) : ViewModel() {
    private val _isSummarizeButtonEnabled = MutableStateFlow(false)
    val isSummarizeButtonEnabled: StateFlow<Boolean> = _isSummarizeButtonEnabled

    fun enableSummarizeButton(response: String) {
        _isSummarizeButtonEnabled.value = response.isNotEmpty()
    }

    fun sendSummary(response: String) {
        _state.value = _state.value.updateSymptoms(response)
    }
}