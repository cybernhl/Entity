package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRegisterPhoneRequest(
    @SerialName("region_id") val regionId: String,
    @SerialName("phone") val phone: String,
    @SerialName("vcode") val vcode: String,
    @SerialName("currency_code") val currencyCode: String? = null
)
