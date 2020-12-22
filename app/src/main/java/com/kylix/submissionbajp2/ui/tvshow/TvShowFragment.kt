package com.kylix.submissionbajp2.ui.tvshow

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
import kotlinx.android.synthetic.main.tv_show_fragment.*

class TvShowFragment : Fragment() {

    private var tvShow = listOf<ItemList>()

    private val tvShowViewModel by lazy {
        val viewModelFactory = activity?.application?.let {
            ViewModelFactory.getInstance()
        }
        ViewModelProviders.of(this, viewModelFactory).get(TvShowViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tv_show_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val tvShowAdapter = context?.let { TvShowAdapter(it) }
        tvShowViewModel.tvShow.observe(viewLifecycleOwner, Observer {
            tvShow_progress_bar.visibility = View.GONE
            tvShow = it
            tvShowAdapter?.addList(tvShow)
        })

        rv_tvShow.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = tvShowAdapter
        }
    }
}