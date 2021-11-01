package fr.kienanbachwa.instantnews.data.services

import fr.kienanbachwa.instantnews.data.models.requests.HeadlinesRequest
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * News service containing retrofit queries
 */
interface NewsService {

    @GET("/v2/top-headlines")
    suspend fun requestTopHeadlines(@Query("language") language : String = "fr", @Query("country") country : String = "fr") : HeadlinesRequest

}