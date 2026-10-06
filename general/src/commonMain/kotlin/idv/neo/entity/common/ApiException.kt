package idv.neo.entity.common

import kotlinx.serialization.json.JsonElement

class ApiException(
    val code: Int,
    override val message: String,
    val rawData: JsonElement? = null
) : Exception(message)
