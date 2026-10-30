package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PayPasswordVerifyRequest(
    @SerialName("pay_password") val payPassword: String,
    @SerialName("action") val action: Int
)
