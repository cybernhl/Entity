package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SendEmailRequest(
    @SerialName("email") val email: String,
    @SerialName("type") val type: Int
)
