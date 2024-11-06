package com.example.aidify.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.aidify.models.ParticipantData
import com.example.aidify.models.Question

class UncopeViewModel(private val _state: MutableState<ParticipantData>) : ViewModel() {
    private val _nextScreenBtnEnabled = mutableStateOf(false)
    val nextScreenBtnEnabled: Boolean get() = _nextScreenBtnEnabled.value

    private val _allQuestionsAnswered: State<Boolean> = derivedStateOf {
        _state.value.uncopeQuestions.allAnswered()
    }

    init {
        updateNextScreenButtonState()
    }

    private fun updateNextScreenButtonState() {
        _nextScreenBtnEnabled.value = _allQuestionsAnswered.value
    }

    fun getOptionState(key: Question): Boolean? {
        return when (key) {
            Question.Q1 -> _state.value.uncopeQuestions.q1
            Question.Q2 -> _state.value.uncopeQuestions.q2
            Question.Q3 -> _state.value.uncopeQuestions.q3
            Question.Q4 -> _state.value.uncopeQuestions.q4
            Question.Q5 -> _state.value.uncopeQuestions.q5
            Question.Q6 -> _state.value.uncopeQuestions.q6
        }
    }

    fun updateOptionState(key: Question, value: Boolean) {
        _state.value = _state.value.updateUncopeQuestion(key, value)
        updateNextScreenButtonState()
    }
}