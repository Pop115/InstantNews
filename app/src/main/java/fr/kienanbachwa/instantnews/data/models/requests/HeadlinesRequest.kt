package fr.kienanbachwa.instantnews.data.models.requests

import fr.kienanbachwa.instantnews.data.models.News

/**
 * Headlines response from News API /v2/top-headlines
 */
data class HeadlinesRequest(val totalResults : Int, val articles : List<News>)