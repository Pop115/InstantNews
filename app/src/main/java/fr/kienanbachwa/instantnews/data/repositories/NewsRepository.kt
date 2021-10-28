package fr.kienanbachwa.instantnews.data.repositories

import fr.kienanbachwa.instantnews.MainActivity
import fr.kienanbachwa.instantnews.data.models.requests.HeadlinesRequest
import fr.kienanbachwa.instantnews.data.services.NewsService
import retrofit2.HttpException

class NewsRepository {

    private val newsService: NewsService by lazy{
        MainActivity.retrofitSingleton.create(NewsService::class.java)
    }


    suspend fun requestTopHeadlines(): HeadlinesRequest? {
        try{
            return newsService.requestTopHeadlines()
        }catch (e: HttpException){
            print(e)
        }
        return null
    }

}