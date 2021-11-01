package fr.kienanbachwa.instantnews.data.services

import fr.kienanbachwa.instantnews.data.models.requests.SourcesRequest
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * News service containing retrofit queries
 */
interface SourceService {

    @GET("/v2/top-headlines/sources")
    suspend fun requestSources(@Query("language") language : String = "fr", @Query("country") country : String = "fr") : SourcesRequest
}