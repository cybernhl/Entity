package idv.neo.entity.common

// Ref : https://medium.com/@kerry.bisset/kotlin-serialization-json-mistakes-i-made-with-polymorphism-and-more-e8ae367dc90a
// https://stackoverflow.com/questions/34538392/convert-curl-to-retrofit
// https://slack-chats.kotlinlang.org/t/455846/hello-i-try-convert-this-curl-in-kotlin-using-retrofit-2-but

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNames

/**
 * [方案 A 實作]
 * 單一 Rich Data Class，同時具備 Network DTO、UI 狀態能力與 Exception 轉換方法。
 */
@OptIn(ExperimentalSerializationApi::class)
@Serializable(with = ApiResponseSerializer::class)
data class ApiResponse<T>(
    @SerialName("code")
    @JsonNames("ret", "code")
    val code: Int = -1,

    @SerialName("message")
    @JsonNames("msg", "message")
    val message: String = "",

    @SerialName("data")
    val data: T? = null,

    val rawData: JsonElement? = null,

    val isLoading: Boolean = false
) {

    val isSuccess: Boolean get() = (code == 200 || code == 202 || code == 0) && !isLoading
    val isFailure: Boolean get() = !isSuccess && !isLoading
    val isEmpty: Boolean get() = isSuccess && data == null

    /** 轉為 Exception 物件（Kotlin 帶有泛型參數 <T> 之類別無法直接繼承 Throwable，故提供轉寫屬性） */
    val exception: Exception
        get() = ApiException(code, message, rawData)

    inline fun onSuccess(block: (data: T) -> Unit): ApiResponse<T> {
        if (isSuccess && data != null) {
            block(data)
        }
        return this
    }

    inline fun onFailure(block: (code: Int, msg: String) -> Unit): ApiResponse<T> {
        if (isFailure) {
            block(code, message)
        }
        return this
    }

    inline fun onLoading(block: () -> Unit): ApiResponse<T> {
        if (isLoading) {
            block()
        }
        return this
    }

    fun getOrNull(): T? = if (isSuccess) data else null
    fun getOrDefault(default: T): T = getOrNull() ?: default

    companion object {
        fun <T> loading(): ApiResponse<T> = ApiResponse(isLoading = true)
    }
}
