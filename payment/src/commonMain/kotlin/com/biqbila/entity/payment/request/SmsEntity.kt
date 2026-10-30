package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SendSmsRequest(
    @SerialName("region_id") val regionId: String,
    @SerialName("phone") val phone: String,
    @SerialName("type") val type: Int
)
