package com.example.aidify.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.aidify.models.ParticipantData

class OpenEndedViewModel(private val _state: MutableState<ParticipantData>) : ViewModel() {
    // State to track if the Next button should be enabled
    private val _nextScreenBtnEnabled = mutableStateOf(false)
    val nextScreenBtnEnabled: Boolean get() = _nextScreenBtnEnabled.value

    // State to check if the input field (q1) has been filled out
    private val _isQuestionAnswered: State<Boolean> = derivedStateOf {
        _state.value.openQuestions.q1?.isNotBlank() == true
    }

    init {
        updateNextScreenButtonState()
    }

    private fun updateNextScreenButtonState() {
        _nextScreenBtnEnabled.value = _isQuestionAnswered.value
    }

    fun updateAnswer(text: String) {
        // Update q1 in openQuestions with the provided text
        _state.value = _state.value.copy(
            openQuestions = _state.value.openQuestions.copy(q1 = text)
        )
        updateNextScreenButtonState()
    }
}
