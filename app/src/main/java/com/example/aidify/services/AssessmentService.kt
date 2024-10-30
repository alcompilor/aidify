package com.example.aidify.services

import android.util.Log
import com.example.aidify.BuildConfig
import com.example.aidify.models.ParticipantData
import com.example.aidify.models.ResponseData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class AssessmentService {
    private val participantEndpoint = BuildConfig.AI_ENDPOINT_PARTICIPANT
    private val timeout: Long = 30000
    private val client: HttpClient = HttpClient(CIO) {
        install(HttpTimeout) {
            requestTimeoutMillis = timeout
            connectTimeoutMillis = timeout
            socketTimeoutMillis = timeout
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
    }

    suspend fun requestAIProcessing(data: ParticipantData): ParticipantData {
        val jsonData = Json.encodeToString(
            mapOf(
                "payload" to data
            )
        )

        println(jsonData)
        val response: HttpResponse = client.post(participantEndpoint) {
            contentType(ContentType.Application.Json)
            setBody(jsonData)
        }

        return if (response.status.isSuccess()) {
            response.body<ResponseData>().content
        } else {
            Log.e("requestAIProcessing", "Request error: ${response.status}")
            throw Exception("Failed to process AI request: ${response.status}")
        }
    }
}