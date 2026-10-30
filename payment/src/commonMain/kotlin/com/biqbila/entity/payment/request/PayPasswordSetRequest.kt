package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PayPasswordSetRequest(
    @SerialName("pay_password") val payPassword: String
)
