package idv.neo.entity.cs.trilivechat.response

import kotlinx.serialization.Serializable

@Serializable
data class BindTokenResponse(
    val success: Boolean = false,
    val username: String? = null,
    val detail: String? = null
)