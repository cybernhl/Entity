 package idv.neo.entity.common

 import kotlinx.serialization.KSerializer
 import kotlinx.serialization.SerializationException
 import kotlinx.serialization.builtins.serializer
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
  * [方案 A Serializer 參考實作 - 已註解留存]
  */
 class ApiResponseSerializer<T>(private val dataSerializer: KSerializer<T>) :
     KSerializer<ApiResponse<T>> {
     override val descriptor: SerialDescriptor = buildClassSerialDescriptor("ApiResponse") {
         element("code", Int.serializer().descriptor)
         element("message", String.serializer().descriptor)
         element("data", dataSerializer.descriptor, isOptional = true)
     }

     override fun deserialize(decoder: Decoder): ApiResponse<T> {
         val input = decoder as? JsonDecoder
             ?: throw SerializationException("This serializer can be used only with Json format")
         val jsonObject = input.decodeJsonElement().jsonObject

         val code = jsonObject["code"]?.jsonPrimitive?.int
             ?: jsonObject["ret"]?.jsonPrimitive?.int ?: -1
         val message = jsonObject["message"]?.jsonPrimitive?.content
             ?: jsonObject["msg"]?.jsonPrimitive?.content ?: ""

         val dataElement = jsonObject["data"]
         val data =
             if (dataElement == null || dataElement is JsonNull || (dataElement is JsonArray && dataElement.isEmpty())) {
                 null
             } else {
                 try {
                     input.json.decodeFromJsonElement(dataSerializer, dataElement)
                 } catch (e: Exception) {
                     null
                 }
             }

         return ApiResponse(code, message, data, dataElement)
     }

     override fun serialize(encoder: Encoder, value: ApiResponse<T>) {
         val output = encoder as? JsonEncoder
             ?: throw SerializationException("This serializer can be used only with Json format")
         val json = buildJsonObject {
             put("code", value.code)
             put("message", value.message)
             put(
                 "data",
                 value.data?.let { output.json.encodeToJsonElement(dataSerializer, it) }
                     ?: value.rawData ?: JsonNull
             )
         }
         output.encodeJsonElement(json)
     }
 }
