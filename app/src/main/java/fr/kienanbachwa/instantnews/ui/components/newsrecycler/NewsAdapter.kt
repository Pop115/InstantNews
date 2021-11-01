package fr.kienanbachwa.instantnews.ui.components.newsrecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.kienanbachwa.instantnews.R
import fr.kienanbachwa.instantnews.data.models.News
import fr.kienanbachwa.instantnews.ui.fragments.FragmentNewsDetail

class NewsAdapter(
    private val newsList: MutableList<News> = mutableListOf<News>(),
    private val fragmentManager: FragmentManager
) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        val newsItem = newsList[position]

        holder.newsTitle.text = newsItem.title?.let { HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT) }
        holder.newsDescription.text = newsItem.description?.let { HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT) }

        //using the Glide library to load the picture asynchronously (https://github.com/bumptech/glide)
        Glide.with(holder.itemView).load(newsItem.urlToImage).into(holder.newsPicture)

        holder.newsCard.setOnClickListener { openNewsDetail(newsItem) }
    }

    override fun getItemCount(): Int {
        return newsList.size;
    }

    fun addNews(newNewsList: List<News>) {
        this.newsList.addAll(newNewsList)
        this.notifyItemRangeInserted(newsList.size - newNewsList.size, newNewsList.size)
    }

    private fun openNewsDetail(news: News) {
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, FragmentNewsDetail(news), null)
            .addToBackStack(null)
            .commit()
    }
}