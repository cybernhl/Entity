package com.biqbila.entity.payment.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetThirdPartyDepositRequest(
    @SerialName("order_no") val orderNo: String
)
