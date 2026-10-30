package idv.neo.entity.cs.trilivechat.request

import kotlinx.serialization.Serializable

@Serializable
data class TypingRequest(
    val sessionId: String,
    val content: String? = null
)