package idv.neo.entity.cs.trilivechat.response

import kotlinx.serialization.Serializable

@Serializable
data class SessionDetailResponse(
    val success: Boolean = false,
    val status: String? = null,
    val site: SiteInfo? = null,
    val agent: AgentInfo? = null,
    val faqs: List<FaqItem>? = emptyList(),
    val detail: String? = null
)