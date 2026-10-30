package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateThirdPartyDepositRequest(
    @SerialName("quota_id") val quotaId: Long,
    @SerialName("quote_version_id") val quoteVersionId: Long,
    @SerialName("amount") val amount: String,
    @SerialName("idempotency_key") val idempotencyKey: String
)
