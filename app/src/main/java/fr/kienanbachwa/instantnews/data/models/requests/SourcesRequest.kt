package fr.kienanbachwa.instantnews.data.models.requests

import fr.kienanbachwa.instantnews.data.models.Source

/**
 * Everything response from News API /v2/everything
 */
data class SourcesRequest(val status: String, val sources: List<Source>)