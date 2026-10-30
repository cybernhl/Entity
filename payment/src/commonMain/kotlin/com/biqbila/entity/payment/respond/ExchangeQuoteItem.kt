package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeQuoteItem(
    @SerialName("id") val id: Long = 0,
    @SerialName("quota_id") val quotaId: Long = 0,
    @SerialName("quote_version_id") val quoteVersionId: Long = 0,
    @SerialName("display_name") val displayName: String = "",
    @SerialName("remark") val remark: String = "",
    @SerialName("source_currency_code") val sourceCurrencyCode: String = "",
    @SerialName("target_currency_code") val targetCurrencyCode: String = "",
    @SerialName("rate") val rate: String = "",
    @SerialName("source_fee_rate") val sourceFeeRate: String = "",
    @SerialName("source_fixed_fee") val sourceFixedFee: String = "",
    @SerialName("target_fee_rate") val targetFeeRate: String = "",
    @SerialName("target_fixed_fee") val targetFixedFee: String = "",
    @SerialName("min_source_principal_amount") val minSourcePrincipalAmount: String = "",
    @SerialName("max_source_principal_amount") val maxSourcePrincipalAmount: String? = null,
    @SerialName("remain_target_amount") val remainTargetAmount: String = ""
)

@Serializable
data class ExchangeQuotesResponseData(
    @SerialName("total") val total: Long = 0,
    @SerialName("page") val page: Int = 1,
    @SerialName("page_size") val pageSize: Int = 20,
    @SerialName("items") val items: List<ExchangeQuoteItem> = emptyList()
)
