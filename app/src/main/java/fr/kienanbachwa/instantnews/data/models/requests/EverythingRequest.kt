package fr.kienanbachwa.instantnews.data.models.requests

import fr.kienanbachwa.instantnews.data.models.News

/**
 * Everything response from News API /v2/everything
 */
data class EverythingRequest(val status : String, val totalResults : Int, val articles : List<News>)