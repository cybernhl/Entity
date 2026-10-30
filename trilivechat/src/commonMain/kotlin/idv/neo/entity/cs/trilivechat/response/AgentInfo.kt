package idv.neo.entity.cs.trilivechat.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AgentInfo(
    val name: String? = null,
    @SerialName("avatar_url") val avatarUrl: String? = null
)