package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ThirdPartyDepositCreateResponseData(
    @SerialName("order_no") val orderNo: String = "",
    @SerialName("status") val status: String = ""
)
