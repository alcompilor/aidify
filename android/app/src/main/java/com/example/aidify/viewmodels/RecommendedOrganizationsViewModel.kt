package com.example.aidify.viewmodels

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.aidify.models.Organization
import com.example.aidify.models.ParticipantData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecommendedOrganizationsViewModel(state: MutableState<ParticipantData>) : ViewModel() {

    private val _organizations = MutableStateFlow<List<Organization>>(emptyList())
    val organizations: StateFlow<List<Organization>> = _organizations.asStateFlow()

    init {
        _organizations.value = state.value.result.organizations
    }
}
