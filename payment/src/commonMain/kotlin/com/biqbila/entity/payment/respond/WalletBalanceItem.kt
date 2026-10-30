package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WalletBalanceItem(
    @SerialName("currency_code") val currencyCode: String = "",
    @SerialName("balance") val balance: String = "0.00",
    @SerialName("frozen_amount") val frozenAmount: String = "0.00"
)
