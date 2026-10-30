package com.biqbila.entity.payment

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoneyNumberFormatCatalog(
    @SerialName("version") val version: Int = 2,
    @SerialName("default_style") val defaultStyle: String = "dot_decimal",
    @SerialName("styles") val styles: Map<String, MoneyNumberStyleDto> = emptyMap(),
    @SerialName("countries") val countries: List<MoneyNumberCountryDto> = emptyList()
)