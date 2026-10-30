package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LanguageItem(
    @SerialName("code") val code: String = "",
    @SerialName("name") val name: String = "",
    @SerialName("state") val state: Int = 0
)
