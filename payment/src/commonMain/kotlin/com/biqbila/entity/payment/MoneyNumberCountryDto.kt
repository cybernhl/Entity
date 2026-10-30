package com.biqbila.entity.payment

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoneyNumberCountryDto(
    @SerialName("iso") val iso: String = "",
    @SerialName("calling_code") val callingCode: String = "",
    @SerialName("style") val style: String = "dot_decimal"
)