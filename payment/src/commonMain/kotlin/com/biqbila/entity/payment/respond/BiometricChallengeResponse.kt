package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BiometricChallengeResponse(
    @SerialName("challenge_id") val challengeId: String = "",
    @SerialName("expire_in") val expireIn: Long = 0
)
