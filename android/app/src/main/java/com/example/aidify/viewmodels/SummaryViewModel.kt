package com.example.aidify.viewmodels

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.example.aidify.models.ParticipantData


class SummaryViewModel(private val state: State<ParticipantData>) : ViewModel() {

    fun getFeedback(): String? = state.value.result.summary.feedback

    fun getDiagnosis(): String? = state.value.result.summary.assessment

    fun getRiskOfAbuse(): String? = state.value.result.summary.abuseRisk

}
