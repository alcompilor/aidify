package com.example.aidify.viewmodels

import android.app.Application
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.aidify.utilities.getSavedLanguageCode

class WelcomeViewModel: ViewModel() {
    private val _dropdownExpanded = mutableStateOf(false)
    val dropdownExpanded get() = _dropdownExpanded.value

    fun updateDropdownExpansion(value: Boolean) {
        _dropdownExpanded.value = value
    }
}