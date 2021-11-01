package fr.kienanbachwa.instantnews.data.repositories

import fr.kienanbachwa.instantnews.MainActivity
import fr.kienanbachwa.instantnews.data.models.requests.HeadlinesRequest
import fr.kienanbachwa.instantnews.data.services.NewsService
import retrofit2.HttpException
import java.util.logging.Logger

class NewsRepository() {

    private val LOGGER: Logger = Logger.getLogger(this.javaClass.name)

    private val newsService: NewsService by lazy {
        MainActivity.retrofitSingleton.create(NewsService::class.java)
    }

    suspend fun requestTopHeadlines(): HeadlinesRequest? {
        try {
            return newsService.requestTopHeadlines()
        } catch (e: HttpException) {
            LOGGER.warning(e.message())
        }
        return null
    }


}