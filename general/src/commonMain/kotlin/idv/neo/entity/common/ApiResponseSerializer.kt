package idv.neo.entity.common

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.put

/**
 * 方案 B 專用 Custom Serializer
 * 解析 JSON 並自動轉換為適當的 Sealed 分支 (Success / Error / Empty)。
 */
class ApiResponseSerializer<T>(private val dataSerializer: KSerializer<T>) :
    KSerializer<ApiResponse<T>> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("ApiResponse")

    override fun deserialize(decoder: Decoder): ApiResponse<T> {
        val input = decoder as? JsonDecoder
            ?: throw SerializationException("This serializer can be used only with Json format")
        val jsonObject = input.decodeJsonElement().jsonObject

        val code = jsonObject["code"]?.jsonPrimitive?.int
            ?: jsonObject["ret"]?.jsonPrimitive?.int ?: -1
        val message = jsonObject["message"]?.jsonPrimitive?.content
            ?: jsonObject["msg"]?.jsonPrimitive?.content ?: ""

        val dataElement = jsonObject["data"]
        val isSuccessCode = (code == 200 || code == 202 || code == 0)

        if (!isSuccessCode) {
            return ApiResponse.Error(code = code, message = message, rawData = dataElement)
        }

        if (dataElement == null || dataElement is JsonNull || (dataElement is JsonArray && dataElement.isEmpty())) {
            return ApiResponse.Empty
        }

        return try {
            val data = input.json.decodeFromJsonElement(dataSerializer, dataElement)
            ApiResponse.Success(code = code, message = message, data = data)
        } catch (e: Exception) {
            ApiResponse.Error(
                code = code,
                message = "Data decode error: ${e.message}",
                rawData = dataElement,
                cause = e
            )
        }
    }

    override fun serialize(encoder: Encoder, value: ApiResponse<T>) {
        val output = encoder as? JsonEncoder
            ?: throw SerializationException("This serializer can be used only with Json format")

        when (value) {
            is ApiResponse.Success -> {
                val json = buildJsonObject {
                    put("code", value.code)
                    put("message", value.message)
                    put("data", output.json.encodeToJsonElement(dataSerializer, value.data))
                }
                output.encodeJsonElement(json)
            }
            is ApiResponse.Error -> {
                val json = buildJsonObject {
                    put("code", value.code)
                    put("message", value.message)
                    value.rawData?.let { put("data", it) }
                }
                output.encodeJsonElement(json)
            }
            is ApiResponse.Loading -> {
                val json = buildJsonObject {
                    put("code", 0)
                    put("message", "loading")
                }
                output.encodeJsonElement(json)
            }
            is ApiResponse.Empty -> {
                val json = buildJsonObject {
                    put("code", 200)
                    put("message", "empty")
                    put("data", JsonNull)
                }
                output.encodeJsonElement(json)
            }
        }
    }
}