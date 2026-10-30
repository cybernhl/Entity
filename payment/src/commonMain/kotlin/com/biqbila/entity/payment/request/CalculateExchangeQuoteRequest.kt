package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CalculateExchangeQuoteRequest(
    @SerialName("source_principal_amount") val sourcePrincipalAmount: String
)
