package fr.kienanbachwa.instantnews.data.models.requests

import fr.kienanbachwa.instantnews.data.models.Source

/**
 * Source response from News API /v2/top-headlines/sources
 */
data class SourcesRequest(val status: String, val sources: List<Source>)