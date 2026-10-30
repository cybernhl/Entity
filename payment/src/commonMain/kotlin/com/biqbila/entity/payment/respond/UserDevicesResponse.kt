package com.biqbila.entity.payment.respond

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDevicesData(
    @SerialName("total") val total: Long = 0,
    @SerialName("page") val page: Int = 1,
    @SerialName("page_size") val pageSize: Int = 10,
    @SerialName("items") val items: List<DeviceItem> = emptyList()
)

@Serializable
data class DeviceItem(
    @SerialName("id") val id: Long = 0,
    @SerialName("device_no") val deviceNo: String = "",
    @SerialName("device_name") val deviceName: String = "",
    @SerialName("device_type") val deviceType: String = "",
    @SerialName("os_version") val osVersion: String = "",
    @SerialName("app_version") val appVersion: String = "",
    @SerialName("action") val action: String = "",
    @SerialName("ip") val ip: String = "",
    @SerialName("created_at") val createdAt: Long = 0
)
