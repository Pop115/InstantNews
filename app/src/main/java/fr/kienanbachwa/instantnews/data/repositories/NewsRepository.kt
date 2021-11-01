package fr.kienanbachwa.instantnews.data.repositories

import fr.kienanbachwa.instantnews.MainActivity
import fr.kienanbachwa.instantnews.data.models.requests.EverythingRequest
import fr.kienanbachwa.instantnews.data.services.NewsService
import retrofit2.HttpException
import java.util.logging.Logger

class NewsRepository {

    private val logger: Logger = Logger.getLogger(this.javaClass.name)

    private val newsService: NewsService by lazy {
        MainActivity.retrofitSingleton.create(NewsService::class.java)
    }

    suspend fun requestTopHeadlines(): EverythingRequest? {
        try {
            return newsService.requestEverything()
        } catch (e: HttpException) {
            logger.warning(e.message())
        }
        return null
    }


}