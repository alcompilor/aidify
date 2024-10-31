package com.example.aidify.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.aidify.models.MisuseType
import com.example.aidify.models.ParticipantData

class AddictionChoiceViewModel(private val _state: MutableState<ParticipantData>) : ViewModel() {
    
    private val _continueBtnEnabled = mutableStateOf(false)
    val continueBtnEnabled: Boolean get() = _continueBtnEnabled.value

    init {
        updateContinueButtonState()
    }

    fun getMisuseType(): MisuseType? {
        return _state.value.misuseType
    }

    fun setMisuseType(misuseType: MisuseType) {
        _state.value = _state.value.updateMisuseType(misuseType)
        updateContinueButtonState()
    }

    private fun updateContinueButtonState() {
        _continueBtnEnabled.value = (_state.value.misuseType != null)
    }
}
