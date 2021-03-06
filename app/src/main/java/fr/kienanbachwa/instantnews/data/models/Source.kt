package fr.kienanbachwa.instantnews.data.models

/**
 * Source data object
 */
data class Source(
    val id: String,
    val name: String?,
    val description: String?,
    val url: String?,
    val category: String?,
    val language: String?,
    val country: String?
)