package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ThirdPartyDepositResponseData(
    @SerialName("order_no") val orderNo: String = "",
    @SerialName("status") val status: String = "",
    @SerialName("source_currency_code") val sourceCurrencyCode: String = "",
    @SerialName("target_currency_code") val targetCurrencyCode: String = "",
    @SerialName("source_payable_amount") val sourcePayableAmount: String = "",
    @SerialName("net_target_amount") val netTargetAmount: String = "",
    @SerialName("payment_expires_at") val paymentExpiresAt: Long = 0,
    @SerialName("payment_url") val paymentUrl: String? = null,
    @SerialName("provider_order_no") val providerOrderNo: String? = null,
    @SerialName("failure_code") val failureCode: String? = null
)
