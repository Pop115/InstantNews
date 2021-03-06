package fr.kienanbachwa.instantnews.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import fr.kienanbachwa.instantnews.data.models.News
import fr.kienanbachwa.instantnews.databinding.FragmentNewsDetailBinding

/**
 * Fragment displaying the details of a news
 */
class FragmentNewsDetail(private val news: News) : Fragment() {

    private var _binding: FragmentNewsDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNewsDetailBinding.inflate(inflater, container, false)

        binding.newsSourceButton.setOnClickListener { redirectToNewsUrl() }
        binding.newsTitle.text = this.news.title?.let { HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT) }
        binding.newsDescription.text = this.news.content?.let { HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY) }

        //using the Glide library to load the picture asynchronously (https://github.com/bumptech/glide)
        if(news.urlToImage?.startsWith("http://") == false) {//don't request http cleartext url
            Glide.with(binding.newsPicture).load(news.urlToImage).into(binding.newsPicture)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Open the source of the news in an external browser
     */
    private fun redirectToNewsUrl() {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(news.url))
        startActivity(browserIntent)
    }
}