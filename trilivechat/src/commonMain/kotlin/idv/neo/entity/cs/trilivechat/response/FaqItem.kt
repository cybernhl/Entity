package idv.neo.entity.cs.trilivechat.response

import kotlinx.serialization.Serializable

@Serializable
data class FaqItem(
    val question: String? = null,
    val answer: String? = null
)