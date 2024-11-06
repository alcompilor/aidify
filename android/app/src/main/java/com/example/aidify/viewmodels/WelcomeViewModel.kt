package com.example.aidify.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {
    private val _dropdownExpanded = mutableStateOf(false)
    val dropdownExpanded get() = _dropdownExpanded.value

    fun updateDropdownExpansion(value: Boolean) {
        _dropdownExpanded.value = value
    }
}