package idv.neo.entity.cs.trilivechat.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SiteInfo(
    val name: String? = null,
    val domain: String? = null,
    @SerialName("logo_url") val logoUrl: String? = null,
    @SerialName("theme_color") val themeColor: String? = null,
    val lang: String? = null
)