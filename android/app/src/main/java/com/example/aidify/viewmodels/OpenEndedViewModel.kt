package com.example.aidify.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.aidify.models.ParticipantData
import com.example.aidify.models.Question

class OpenEndedViewModel(private val _state: MutableState<ParticipantData>) : ViewModel() {
    private val _nextScreenBtnEnabled = mutableStateOf(false)
    val nextScreenBtnEnabled: Boolean get() = _nextScreenBtnEnabled.value

    private val _areQuestionsAnswered: State<Boolean> = derivedStateOf {
        _state.value.openQuestions.allAnswered()
    }

    init {
        updateNextScreenButtonState()
    }

    private fun updateNextScreenButtonState() {
        _nextScreenBtnEnabled.value = _areQuestionsAnswered.value
    }

    fun updateAnswer(question: Question, value: String) {
        _state.value = _state.value.updateOpenQuestion(question, value)
        updateNextScreenButtonState()
    }

    fun getAnswer(question: Question): String? {
        return when (question) {
            Question.Q1 -> _state.value.openQuestions.q1
            Question.Q2 -> _state.value.openQuestions.q2
            else -> null
        }
    }
}