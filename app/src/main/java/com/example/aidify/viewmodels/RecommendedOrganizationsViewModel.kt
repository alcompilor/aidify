package com.example.aidify.viewmodels

import androidx.lifecycle.ViewModel
import com.example.aidify.models.Organization
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecommendedOrganizationsViewModel(dataViewModel: DataViewModel) : ViewModel() {

    private val _organizations = MutableStateFlow<List<Organization>>(emptyList())
    val organizations: StateFlow<List<Organization>> = _organizations.asStateFlow()

    init {
        _organizations.value = dataViewModel.state.value.result.organizations ?: emptyList()
    }
}
