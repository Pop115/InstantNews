package fr.kienanbachwa.instantnews.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import fr.kienanbachwa.instantnews.data.repositories.NewsRepository
import fr.kienanbachwa.instantnews.databinding.FragmentNewsListBinding
import fr.kienanbachwa.instantnews.ui.components.newsrecycler.NewsAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FragmentNewsList : Fragment() {

    private var _binding: FragmentNewsListBinding? = null
    private var newsRepository: NewsRepository? = NewsRepository()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)

        binding.newsRecycler.adapter = NewsAdapter()
        binding.newsRecycler.layoutManager = LinearLayoutManager(this.context)

        getNewsList()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun getNewsList() {
        activity?.runOnUiThread{
            CoroutineScope(Dispatchers.IO).launch {
                val headlinesRequest = newsRepository?.requestTopHeadlines()
                if (headlinesRequest != null) {
                    val newsAdapter = (binding.newsRecycler.adapter as NewsAdapter)
                    newsAdapter.addNews(headlinesRequest.articles)
                }
            }
        }
    }
}