package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeQuoteCalculation(
    @SerialName("quota_id") val quotaId: Long = 0,
    @SerialName("quote_id") val quoteId: Long = 0,
    @SerialName("quote_version_id") val quoteVersionId: Long = 0,
    @SerialName("source_currency_code") val sourceCurrencyCode: String = "",
    @SerialName("target_currency_code") val targetCurrencyCode: String = "",
    @SerialName("source_principal_amount") val sourcePrincipalAmount: String = "",
    @SerialName("source_fee_rate") val sourceFeeRate: String = "",
    @SerialName("source_fixed_fee") val sourceFixedFee: String = "",
    @SerialName("source_fee_amount") val sourceFeeAmount: String = "",
    @SerialName("source_payable_amount") val sourcePayableAmount: String = "",
    @SerialName("rate") val rate: String = "",
    @SerialName("gross_target_amount") val grossTargetAmount: String = "",
    @SerialName("target_fee_rate") val targetFeeRate: String = "",
    @SerialName("target_fixed_fee") val targetFixedFee: String = "",
    @SerialName("target_fee_amount") val targetFeeAmount: String = "",
    @SerialName("net_target_amount") val netTargetAmount: String = ""
)
