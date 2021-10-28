package fr.kienanbachwa.instantnews.data.services

import android.content.Context
import com.squareup.moshi.Moshi
import fr.kienanbachwa.instantnews.R
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {

    /**
     * create the retrofit singleton
     */
    fun createRetrofitInstance(context: Context): Retrofit {
        val retrofitBuilder = Retrofit.Builder()
        retrofitBuilder.baseUrl(context.getString(R.string.news_url))
        configConverter(retrofitBuilder)
        configAPIKey(retrofitBuilder, context)
        return retrofitBuilder.build()
    }

    /**
     * moshi is used to convert json to java/kotlin objects
     */
    private fun configConverter(retrofitBuilder: Retrofit.Builder) {
        val moshi = Moshi.Builder().build()
        retrofitBuilder.addConverterFactory(MoshiConverterFactory.create(moshi))
    }

    /**
     * Configured for News API but if we had multiple sources we could have another parameter to specify the source
     */
    private fun configAPIKey(retrofitBuilder: Retrofit.Builder, context: Context) {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain: Interceptor.Chain ->
            val httpUrl = chain.request().url().newBuilder()
                .addQueryParameter("apiKey", context.getString(R.string.news_api_key)).build()
            val requestBuilder = chain.request().newBuilder().url(httpUrl)
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        retrofitBuilder.client(httpClient.build())
    }
}