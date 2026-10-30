package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExistsResponseData(
    @SerialName("exists") val exists: Boolean = false
)
