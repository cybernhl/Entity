package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BiometricPayChallengeRequest(
    @SerialName("action") val action: Int
)
