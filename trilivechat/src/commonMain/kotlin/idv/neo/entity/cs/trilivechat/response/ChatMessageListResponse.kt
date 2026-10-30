package idv.neo.entity.cs.trilivechat.response

import kotlinx.serialization.Serializable

@Serializable
data class ChatMessageListResponse(
    val success: Boolean = false,
    val status: String? = null,
    val staffName: String? = null,
    val staffAvatar: String? = null,
    val messages: List<ChatMessageItem> = emptyList()
)