package idv.neo.entity.common

// Ref : https://medium.com/@kerry.bisset/kotlin-serialization-json-mistakes-i-made-with-polymorphism-and-more-e8ae367dc90a
// https://stackoverflow.com/questions/34538392/convert-curl-to-retrofit
// https://slack-chats.kotlinlang.org/t/455846/hello-i-try-convert-this-curl-in-kotlin-using-retrofit-2-but

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNames

/**
 * [方案 B 核心實作]
 * 定義為 Sealed Interface，完美融合 Network Response DTO、UI 狀態 (Loading/Empty/Success/Error)
 * 與 Throwable 異常處置。適用於 Compose `when(response) { is ApiResponse.Success -> ... }` 的模式匹配。
 */
@OptIn(ExperimentalSerializationApi::class)
@Serializable(with = ApiResponseSerializer::class)
sealed interface ApiResponse<out T> {

    /** 1. 成功狀態 (帶有資料與業務碼) */
    @Serializable
    data class Success<out T>(
        @SerialName("code")
        @JsonNames("ret", "code")
        val code: Int = 200,

        @SerialName("message")
        @JsonNames("msg", "message")
        val message: String = "success",

        @SerialName("data")
        val data: T
    ) : ApiResponse<T>

    /** 2. 失敗 / 異常狀態 (同時繼承 Throwable，整合原 ApiException 功能) */
    @Serializable
    data class Error(
        @SerialName("code")
        @JsonNames("ret", "code")
        val code: Int = -1,
        // 修復欄位覆蓋衝突：Error 繼承了父類別 Throwable(message, cause)，其中的 message 必須明確標示 override。
        @SerialName("message")
        @JsonNames("msg", "message")
        override val message: String = "",
        val rawData: JsonElement? = null,
        // 修復 Serializer 崩潰：kotlinx.serialization 預設會試圖序列化 constructor 內的所有欄位，但 Throwable 不是 @Serializable 類別。加上 @Transient 可指示序列化器跳過此欄位。
        @Transient
        override val cause: Throwable? = null
    ) : ApiResponse<Nothing>, Throwable(message, cause)

    /** 3. UI 載入中狀態 */
    data object Loading : ApiResponse<Nothing>

    /** 4. 空資料狀態 */
    data object Empty : ApiResponse<Nothing>

    // --- UI 便捷屬性 ---
    val isSuccess: Boolean get() = this is Success
    val isError: Boolean get() = this is Error
    val isLoading: Boolean get() = this is Loading

    fun getOrNull(): T? = (this as? Success)?.data
}

// --- 擴充 Extension Functions ---
// 修復 Kotlin 介面限制：Kotlin 規定 interface 內部的虛擬成員函式禁止使用 inline；移至介面外部作為擴充函式即可合法標註 inline。
inline fun <T> ApiResponse<T>.onSuccess(action: (data: T) -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Success) action(data)
    return this
}

inline fun <T> ApiResponse<T>.onError(action: (code: Int, message: String) -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Error) action(code, message)
    return this
}
