package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BiometricRevokeRequest(
    @SerialName("purpose") val purpose: Int,
    @SerialName("password") val password: String
)
