package idv.neo.entity.cs.trilivechat.request

import kotlinx.serialization.Serializable

@Serializable
data class ChatRequest(
    val chatInput: String,
    val sessionId: String,
    val metadata: Map<String, String>? = null
)