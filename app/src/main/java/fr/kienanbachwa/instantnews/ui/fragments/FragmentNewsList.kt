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
        binding.newsRecycler.adapter = NewsAdapter(fragmentManager = this.requireActivity().supportFragmentManager)
        binding.newsRecycler.layoutManager = LinearLayoutManager(this.context)
        getNewsList()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    /**
     * Request the news in a coroutine and add them to the recycler adapter
     */
    private fun getNewsList() {

        //On Dispatchers.Main because we update the UI
        CoroutineScope(Dispatchers.Main).launch {
            val headlinesRequest = newsRepository?.requestTopHeadlines()
            if (headlinesRequest != null) {
                val newsAdapter = (binding.newsRecycler.adapter as NewsAdapter)
                newsAdapter.addNews(headlinesRequest.articles)
                binding.loadingIndicator.visibility = View.GONE
            }
        }

    }
}