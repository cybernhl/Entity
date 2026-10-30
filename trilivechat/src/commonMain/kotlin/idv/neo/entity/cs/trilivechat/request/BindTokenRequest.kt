package idv.neo.entity.cs.trilivechat.request
import kotlinx.serialization.Serializable

@Serializable
data class BindTokenRequest(
    val token: String
)