package com.biqbila.entity.payment

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoneyNumberStyleDto(
    @SerialName("pattern") val pattern: String = "#,##0.00"
)