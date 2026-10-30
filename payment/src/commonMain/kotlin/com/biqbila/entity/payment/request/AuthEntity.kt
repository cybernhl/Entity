package com.biqbila.entity.payment.request

import com.biqbila.entity.payment.respond.TokenPair
import com.biqbila.entity.payment.respond.UserInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    @SerialName("verify_mode") val verifyMode: Int,
    @SerialName("region_id") val regionId: String? = null,
    @SerialName("phone") val phone: String? = null,
    @SerialName("vcode") val vcode: String? = null,
    @SerialName("password") val password: String? = null
) {
    companion object {
        fun bySms(regionId: String, phone: String, vcode: String) = LoginRequest(
            verifyMode = 1,
            regionId = regionId,
            phone = phone,
            vcode = vcode
        )

        fun byPassword(regionId: String, phone: String, password: String) = LoginRequest(
            verifyMode = 2,
            regionId = regionId,
            phone = phone,
            password = password
        )
    }
}




