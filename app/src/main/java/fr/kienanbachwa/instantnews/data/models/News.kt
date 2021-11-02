package fr.kienanbachwa.instantnews.data.models

/**
 * News data object
 */
data class News(
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)