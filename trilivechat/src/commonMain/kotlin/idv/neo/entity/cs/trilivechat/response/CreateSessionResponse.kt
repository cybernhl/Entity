package idv.neo.entity.cs.trilivechat.response

import kotlinx.serialization.Serializable

@Serializable
data class CreateSessionResponse(
    val success: Boolean = false,
    val sessionId: String? = null,
    val detail: String? = null
)