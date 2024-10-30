package com.example.aidify.models
import kotlinx.serialization.Serializable

@Serializable
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

    fun updateOpenQuestion(question: Question, value: String): ParticipantData {
        val updatedOpenQuestions = when (question) {
            Question.Q1 -> openQuestions.copy(q1 = value)
            Question.Q2 -> openQuestions.copy(q2 = value)
            else -> openQuestions
        }
        return this.copy(openQuestions = updatedOpenQuestions)
    }

    fun updateUncopeQuestion(question: Question, value: Boolean): ParticipantData {
        val updatedUncopeQuestions = when (question) {
            Question.Q1 -> uncopeQuestions.copy(q1 = value)
            Question.Q2 -> uncopeQuestions.copy(q2 = value)
            Question.Q3 -> uncopeQuestions.copy(q3 = value)
            Question.Q4 -> uncopeQuestions.copy(q4 = value)
            Question.Q5 -> uncopeQuestions.copy(q5 = value)
            Question.Q6 -> uncopeQuestions.copy(q6 = value)
            else -> uncopeQuestions
        }
        return this.copy(uncopeQuestions = updatedUncopeQuestions)
    }

    fun updateSymptoms(value: String): ParticipantData {
        return this.copy(symptoms = value)
    }

    fun updateSummary(value: Summary): ParticipantData {
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

@Serializable
enum class MisuseType {
    ALCOHOL,
    SUBSTANCE
}

@Serializable
enum class Question {
    Q1,
    Q2,
    Q3,
    Q4,
    Q5,
    Q6
}

@Serializable
data class UncopeQuestions(
    val q1: Boolean? = null,
    val q2: Boolean? = null,
    val q3: Boolean? = null,
    val q4: Boolean? = null,
    val q5: Boolean? = null,
    val q6: Boolean? = null,
) {
    fun allAnswered(): Boolean {
        return listOf(q1, q2, q3, q4, q5, q6).all { it != null }
    }
}

@Serializable
data class OpenQuestions(
    val q1: String? = null,
    val q2: String? = null,
) {
    fun allAnswered(): Boolean {
        return listOf(q1, q2).all { it != null }
    }
}

@Serializable
data class Result(
    val summary: Summary = Summary(),
    val organizations: List<Organization> = listOf()
)

@Serializable
data class Organization(
    val name: String,
    val phone: String,
    val email: String,
    val address: String,
    val website: String,
    val description: String? = null,
)

@Serializable
data class Summary(
    val feedback: String? = null,
    val assessment: String? = null,
    val abuseRisk: String? = null
)