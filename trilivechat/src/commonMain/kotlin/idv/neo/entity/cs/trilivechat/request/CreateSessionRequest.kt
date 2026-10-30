package idv.neo.entity.cs.trilivechat.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateSessionRequest(
    @SerialName("site_id") val siteId: String,
    @SerialName("agent_id") val agentId: String,
    val token: String? = null
)