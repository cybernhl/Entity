package idv.neo.entity.cs.trilivechat.response

import kotlinx.serialization.Serializable

@Serializable
data class ChatResponse(
    val output: String? = null,
    val errorCode: String? = null,
    val transfer: Boolean = false,
    val detail: String? = null
)