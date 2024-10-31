package com.example.aidify.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.example.aidify.models.ParticipantData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StageViewModel(private val _state: MutableState<ParticipantData>) : ViewModel() {
    private val _isSubmitButtonEnabled = MutableStateFlow(false)
    val isSubmitButtonEnabled: StateFlow<Boolean> = _isSubmitButtonEnabled
    val state: State<ParticipantData> get() = _state

    fun updateSubmitButton(response: String) {
        _isSubmitButtonEnabled.value = response.isNotEmpty()
    }

    fun pushSymptoms(response: String) {
        _state.value = _state.value.updateSymptoms(response)
    }
}