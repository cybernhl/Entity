package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BiometricStatusResponse(
    @SerialName("device_no") val deviceNo: String = "",
    @SerialName("biometric_login_status") val biometricLoginStatus: Int = 0,
    @SerialName("biometric_pay_status") val biometricPayStatus: Int = 0,
    @SerialName("login_credential_id") val loginCredentialId: String = "",
    @SerialName("pay_credential_id") val payCredentialId: String = ""
) {
    val isLoginEnabled: Boolean get() = biometricLoginStatus == 1
    val isPayEnabled: Boolean get() = biometricPayStatus == 1
}
