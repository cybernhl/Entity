package idv.neo.entity.cs.trilivechat.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChatMessageItem(
    val id: Long? = null,
    @SerialName("sender_type") val senderType: String = "ai", // "ai", "customer", "staff", "system"
    @SerialName("sender_name") val senderName: String? = null,
    val message: String = "",
    val timestamp: String? = null,
    val imageUrl: String? = null
)