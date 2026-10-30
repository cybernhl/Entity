package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class TokenPair(
    @SerialName("access_token") val accessToken: String = "",
    @SerialName("refresh_token") val refreshToken: String = "",
    @SerialName("expires_in") val expiresIn: Long = 1800,
    @SerialName("token_type") val tokenType: String = "Bearer"
)
