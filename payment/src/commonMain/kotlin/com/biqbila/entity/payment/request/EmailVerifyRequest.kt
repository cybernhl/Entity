package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EmailVerifyRequest(
    @SerialName("mail") val mail: String,
    @SerialName("vcode") val vcode: String
)
