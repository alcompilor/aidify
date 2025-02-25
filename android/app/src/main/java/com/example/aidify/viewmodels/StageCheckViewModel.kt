package com.example.aidify.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.example.aidify.models.ParticipantData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StageCheckViewModel(private val _state: MutableState<ParticipantData>) : ViewModel() {
    private val _isStageSubmitButtonEnabled = MutableStateFlow(false)
    val isStageSubmitButtonEnabled: StateFlow<Boolean> = _isStageSubmitButtonEnabled
    val state: State<ParticipantData> get() = _state

    init {
        updateStageSubmitButton(_state.value.symptoms ?: "")
    }

    fun updateStageSubmitButton(response: String) {
        _isStageSubmitButtonEnabled.value = response.isNotEmpty()
    }

    fun pushSymptoms(response: String) {
        _state.value = _state.value.updateSymptoms(response)
    }
}