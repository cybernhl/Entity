package idv.neo.entity.cs.trilivechat.response

import kotlinx.serialization.Serializable

@Serializable
data class UploadResponse(
    val success: Boolean = false,
    val url: String? = null,
    val detail: String? = null
)