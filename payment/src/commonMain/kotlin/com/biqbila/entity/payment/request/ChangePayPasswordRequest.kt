package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChangePayPasswordRequest(
    @SerialName("vcode") val vcode: String,
    @SerialName("pay_password") val payPassword: String
)
