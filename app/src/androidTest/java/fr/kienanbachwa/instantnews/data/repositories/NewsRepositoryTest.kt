package fr.kienanbachwa.instantnews.data.repositories

import androidx.test.platform.app.InstrumentationRegistry
import fr.kienanbachwa.instantnews.data.services.NewsService
import fr.kienanbachwa.instantnews.data.services.RetrofitBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Assert.assertNotNull
import org.junit.Test

class NewsRepositoryTest {

    /**
     * Test if the endpoint of the news API we use is working and return top headlines
     * (test doesn't depend on the code of the application but this API is crucial to the application so I decided to test it)
     */
    @Test
    fun testNewsAPI() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        val retrofit = RetrofitBuilder.createRetrofitInstance(appContext)
        val newsService = retrofit.create(NewsService::class.java)

        CoroutineScope(Dispatchers.Main).launch {
            val everythingRequest = newsService.requestEverything()
            assertNotNull(everythingRequest)
            assertNotNull(everythingRequest.articles)
        }
    }

}