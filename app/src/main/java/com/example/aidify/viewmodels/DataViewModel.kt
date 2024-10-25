package com.example.aidify.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.aidify.models.ParticipantData

class DataViewModel : ViewModel() {
    private val _data = mutableStateOf(ParticipantData())
    val state get() = _data
}