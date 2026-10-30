package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PayTicketResponse(
    @SerialName("pay_ticket") val payTicket: String = "",
    @SerialName("expire_in") val expireIn: Long = 0
)
