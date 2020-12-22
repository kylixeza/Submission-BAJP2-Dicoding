package com.kylix.submissionbajp2.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.kylix.submissionbajp2.R
import com.kylix.submissionbajp2.model.repository.remote.ItemList
import com.kylix.submissionbajp2.util.ViewModelFactory
import kotlinx.android.synthetic.main.movie_fragment.*

class MovieFragment : Fragment() {

    private var movie = listOf<ItemList>()

    private val movieViewModel by lazy {
        val viewModelFactory = activity?.application?.let {
            ViewModelFactory.getInstance()
        }
        ViewModelProviders.of(this, viewModelFactory).get(MovieViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val movieAdapter =
            MovieAdapter(context)
        movieViewModel.movie.observe(viewLifecycleOwner, Observer {
            movie_progress_bar.visibility = View.GONE
            movie = it
            movieAdapter.addList(movie)
        })

        rv_movie.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = movieAdapter
        }
    }
}