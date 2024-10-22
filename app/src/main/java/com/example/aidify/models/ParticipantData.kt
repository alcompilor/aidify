package com.example.aidify.models

data class ParticipantData(
    val misuseType: MisuseType? = null,
    val openQuestions: OpenQuestions = OpenQuestions(),
    val uncopeQuestions: UncopeQuestions = UncopeQuestions(),
    val symptoms: String? = null,
    val result: Result = Result()
) {
    fun updateMisuseType(newType: MisuseType): ParticipantData {
        return this.copy(misuseType = newType)
    }

    fun updateOpenQuestion(question: String, value: String): ParticipantData {
        val updatedOpenQuestions = when (question) {
            "q1" -> openQuestions.copy(q1 = value)
            "q2" -> openQuestions.copy(q2 = value)
            else -> openQuestions
        }
        return this.copy(openQuestions = updatedOpenQuestions)
    }

    fun updateUncopeQuestion(question: String, value: Boolean): ParticipantData {
        val updatedUncopeQuestions = when (question) {
            "q1" -> uncopeQuestions.copy(q1 = value)
            "q2" -> uncopeQuestions.copy(q2 = value)
            "q3" -> uncopeQuestions.copy(q3 = value)
            "q4" -> uncopeQuestions.copy(q4 = value)
            "q5" -> uncopeQuestions.copy(q5 = value)
            "q6" -> uncopeQuestions.copy(q6 = value)
            else -> uncopeQuestions
        }
        return this.copy(uncopeQuestions = updatedUncopeQuestions)
    }

    fun updateSymptoms(value: String): ParticipantData {
        return this.copy(symptoms = value)
    }

    fun updateSummary(value: String): ParticipantData {
        val updatedResult = result.copy(summary = value)
        return this.copy(result = updatedResult)
    }

    fun addOrganization(organization: Organization): ParticipantData {
        val newOrganizations = result.organizations.plus(organization)
        val updatedResult = result.copy(organizations = newOrganizations)
        return this.copy(result = updatedResult)
    }

    fun clearOrganizations(): ParticipantData {
        val updatedResult = result.copy(organizations = emptyList())
        return this.copy(result = updatedResult)
    }

    fun reset(): ParticipantData {
        return ParticipantData()
    }
}

enum class MisuseType {
    ALCOHOL,
    SUBSTANCE
}

data class UncopeQuestions(
    val q1: Boolean? = null,
    val q2: Boolean? = null,
    val q3: Boolean? = null,
    val q4: Boolean? = null,
    val q5: Boolean? = null,
    val q6: Boolean? = null,
)

data class OpenQuestions(
    val q1: String? = null,
    val q2: String? = null,
)

data class Result(
    val summary: String? = null,
    val organizations: List<Organization> = listOf()
)

data class Organization(
    val name: String,
    val phone: String,
    val email: String,
    val address: String,
    val website: String,
    val description: String? = null,
)