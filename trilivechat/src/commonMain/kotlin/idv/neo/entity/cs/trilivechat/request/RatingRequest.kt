package idv.neo.entity.cs.trilivechat.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RatingRequest(
    @SerialName("session_id") val sessionId: String,
    val score: Int,
    val comment: String? = null,
    @SerialName("customer_id") val customerId: String? = null
)