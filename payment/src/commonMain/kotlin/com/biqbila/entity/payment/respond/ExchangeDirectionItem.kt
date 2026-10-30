package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeDirectionItem(
    @SerialName("source_currency_code") val sourceCurrencyCode: String = "",
    @SerialName("target_currency_code") val targetCurrencyCode: String = ""
)
