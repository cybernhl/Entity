package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BiometricLoginRequest(
    @SerialName("challenge_id") val challengeId: String,
    @SerialName("signature") val signature: String,
    @SerialName("sign_count") val signCount: Long
)
