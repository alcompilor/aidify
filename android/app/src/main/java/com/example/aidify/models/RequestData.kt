package com.example.aidify.models

import kotlinx.serialization.Serializable

@Serializable
data class RequestData(
    val payload: ParticipantData,
    val locale: String,
)
