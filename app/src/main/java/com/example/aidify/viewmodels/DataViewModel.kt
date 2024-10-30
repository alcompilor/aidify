package com.example.aidify.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.aidify.models.ParticipantData
import com.example.aidify.models.RequestState
import com.example.aidify.services.AssessmentService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataViewModel : ViewModel() {
    private val assessmentService = AssessmentService()
    private val _data = mutableStateOf(ParticipantData())
    val state get() = _data

    private val _aiRequestState = MutableStateFlow<RequestState<ParticipantData>>(RequestState.Idle)
    val aiRequestState: StateFlow<RequestState<ParticipantData>> get() = _aiRequestState

    fun resetAiRequestState() {
        _aiRequestState.value = RequestState.Idle
    }

    suspend fun performAiProcessing() {
        _aiRequestState.value = RequestState.Loading
        try {
            _data.value = this.assessmentService.requestAIProcessing(_data.value)
            _aiRequestState.value = RequestState.Success(_data.value)
        } catch (e: Exception) {
            _aiRequestState.value =
                RequestState.Error("An error occurred, try again later.")
        }
    }
}