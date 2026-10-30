package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginData(
    @SerialName("user") val user: UserInfo,
    @SerialName("token_pair") val tokenPair: TokenPair
)
