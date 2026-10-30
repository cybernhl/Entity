package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BiometricPayVerifyRequest(
    @SerialName("challenge_id") val challengeId: String,
    @SerialName("signature") val signature: String,
    @SerialName("payload_hash") val payloadHash: String? = null,
    @SerialName("sign_count") val signCount: Long
)
