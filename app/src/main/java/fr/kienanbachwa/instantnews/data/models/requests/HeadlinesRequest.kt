package fr.kienanbachwa.instantnews.data.models.requests

import fr.kienanbachwa.instantnews.data.models.News

data class HeadlinesRequest(val totalResults : Int, val articles : List<News>){
}