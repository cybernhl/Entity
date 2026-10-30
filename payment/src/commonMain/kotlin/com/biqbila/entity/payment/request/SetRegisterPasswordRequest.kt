package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SetRegisterPasswordRequest(
    @SerialName("username") val username: String? = null,
    @SerialName("password") val password: String
)
