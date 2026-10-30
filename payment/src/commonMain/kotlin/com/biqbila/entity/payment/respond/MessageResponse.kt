package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MessageResponse(
    @SerialName("message") val message: String = ""
)
