package com.example.aidify.models

import kotlinx.serialization.Serializable

@Serializable
data class ResponseData(
    val content: ParticipantData,
    val statusCode: Int,
    val fulfilled: Boolean
)