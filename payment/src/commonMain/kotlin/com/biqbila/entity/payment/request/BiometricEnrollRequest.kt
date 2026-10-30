package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BiometricEnrollRequest(
    @SerialName("purpose") val purpose: Int,
    @SerialName("credential_id") val credentialId: String,
    @SerialName("public_key") val publicKey: String,
    @SerialName("algorithm") val algorithm: String = "ECDSA_P256",
    @SerialName("password") val password: String
)
