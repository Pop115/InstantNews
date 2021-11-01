package fr.kienanbachwa.instantnews.data.repositories

import fr.kienanbachwa.instantnews.MainActivity
import fr.kienanbachwa.instantnews.data.models.Source
import fr.kienanbachwa.instantnews.data.models.requests.EverythingRequest
import fr.kienanbachwa.instantnews.data.models.requests.HeadlinesRequest
import fr.kienanbachwa.instantnews.data.services.NewsService
import fr.kienanbachwa.instantnews.data.services.SourceService
import retrofit2.HttpException
import java.util.logging.Logger

class NewsRepository {

    private val logger: Logger = Logger.getLogger(this.javaClass.name)

    private val newsService: NewsService by lazy {
        MainActivity.retrofitSingleton.create(NewsService::class.java)
    }

    private val sourceService : SourceService by lazy {
        MainActivity.retrofitSingleton.create(SourceService::class.java)
    }

    /**
     * returns the top-headlines from the news api
     */
    suspend fun requestTopHeadlines(): HeadlinesRequest? {
        try {
            return newsService.requestTopHeadlines()
        } catch (e: HttpException) {
            logger.warning(e.message())
        }
        return null
    }

    /**
     * /everything endpoint require a list of sources, this method use sources that are in french
     */
    suspend fun requestEverythingFromFrenchSources(): EverythingRequest? {
        try {
            val frenchSources = sourceService.requestSources(language = "fr").sources
            val frenchSourcesStr = frenchSources.joinToString(separator=",", transform={source: Source -> source.id })//put the french sources id as a parameter
            return newsService.requestEverything(sources = frenchSourcesStr)
        } catch (e: HttpException) {
            logger.warning(e.message())
        }
        return null
    }


}