package idv.neo.entity.cs.trilivechat.response

import kotlinx.serialization.Serializable

@Serializable
data class GreetResponse(
    val greeting: String? = null,
    val detail: String? = null
)