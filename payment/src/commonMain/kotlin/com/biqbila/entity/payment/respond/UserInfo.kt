package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(
    @SerialName("id") val id: String = "",
    @SerialName("account") val account: String = "",
    @SerialName("username") val username: String = "",
    @SerialName("phone") val phone: String = "",
    @SerialName("region_id") val regionId: String = "",
    @SerialName("mail") val mail: String = "",
    @SerialName("device_no") val deviceNo: String = "",
    @SerialName("phone_verified_at") val phoneVerifiedAt: Long = 0,
    @SerialName("mail_verified_at") val mailVerifiedAt: Long = 0,
    @SerialName("kyc_verified_at") val kycVerifiedAt: Long = 0,
    @SerialName("password_set") val passwordSet: Boolean = false,
    @SerialName("pay_password_set") val payPasswordSet: Boolean = false,
    @SerialName("is_completed") val isCompleted: Boolean = false,
    @SerialName("next_state") val nextState: Int = 0
)
