package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppConfigData(
    @SerialName("id") val id: Long = 0,
    @SerialName("name") val name: String = "",
    @SerialName("version") val version: Int = 0,
    @SerialName("value") val value: AppConfigValue? = null,
    @SerialName("release_at") val releaseAt: Long = 0,
    @SerialName("state") val state: Int = 0,
    @SerialName("description") val description: String = "",
    @SerialName("created_at") val createdAt: Long = 0,
    @SerialName("updated_at") val updatedAt: Long = 0
)

@Serializable
data class AppConfigValue(
    @SerialName("auth") val auth: AppConfigAuth? = null,
    @SerialName("security") val security: AppConfigSecurity? = null
)

@Serializable
data class AppConfigAuth(
    @SerialName("allow_register") val allowRegister: Boolean = true,
    @SerialName("register_verify_modes") val registerVerifyModes: List<Int> = emptyList(),
    @SerialName("login_verify_modes") val loginVerifyModes: List<Int> = emptyList(),
    @SerialName("default_currencies") val defaultCurrencies: List<String> = emptyList(),
    @SerialName("password_max_retry_count") val passwordMaxRetryCount: Int = 5,
    @SerialName("password_lock_time_minutes") val passwordLockTimeMinutes: Int = 10,
    @SerialName("captcha_expiration_seconds") val captchaExpirationSeconds: Int = 300,
    @SerialName("user_check_max_retry_count") val userCheckMaxRetryCount: Int = 10,
    @SerialName("user_check_lock_time_minutes") val userCheckLockTimeMinutes: Int = 10,
    @SerialName("pay_password_max_retry_count") val payPasswordMaxRetryCount: Int = 5,
    @SerialName("pay_password_lock_time_minutes") val payPasswordLockTimeMinutes: Int = 30
)

@Serializable
data class AppConfigSecurity(
    @SerialName("maintenance_mode") val maintenanceMode: Boolean = false,
    @SerialName("maintenance_notice") val maintenanceNotice: String = "",
    @SerialName("sms_daily_limit_per_phone") val smsDailyLimitPerPhone: Int = 10
)
