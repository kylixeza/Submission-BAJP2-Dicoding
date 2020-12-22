package com.kylix.submissionbajp2.ui.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.kylix.submissionbajp2.R
import com.kylix.submissionbajp2.model.repository.remote.ItemList
import com.kylix.submissionbajp2.model.repository.remote.TvShowDetail
import com.kylix.submissionbajp2.ui.movie.MovieViewModel
import com.kylix.submissionbajp2.ui.tvshow.TvShowViewModel
import com.kylix.submissionbajp2.util.ViewModelFactory
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object{
        const val TITLE = "title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        app_bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener{_, verticallOffest ->
            if (collapseToolbar.height + verticallOffest < 2 * ViewCompat.getMinimumHeight(collapseToolbar)){
                collapseToolbar.setCollapsedTitleTextColor(Color.BLACK)
                toolbar.apply {
                    setNavigationIcon(R.drawable.ic_arrow_back)
                    setBackgroundColor(Color.WHITE)
                    title = intent.getStringExtra(TITLE)
                    visibility = View.VISIBLE
                }
            } else {
                collapseToolbar.setExpandedTitleColor(Color.BLACK)
                toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
                toolbar.apply {
                    setNavigationIcon(R.drawable.ic_arrow_back)
                    setBackgroundColor(Color.TRANSPARENT)
                    visibility = View.GONE
                }
            }
        })

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        if (intent.getStringExtra("movie") != null){
            movieDetailViewModel.getMovieDetail(intent.getStringExtra("movie")!!).observe(this, Observer {
                loading()
                loadDataMovie(it)
            })
        }else{
            tvShowDetailViewModel.getTvShowDetail(intent.getStringExtra("tvShow")!!).observe(this, Observer {
                loading()
                loadDataTvShow(it)
            })

        }
    }

    private val movieDetailViewModel by lazy {
        val viewModelFactory = ViewModelFactory.getInstance()
        ViewModelProviders.of(this, viewModelFactory).get(MovieViewModel::class.java)
    }

    private val tvShowDetailViewModel by lazy{
        val viewModelFactory = ViewModelFactory.getInstance()
        ViewModelProviders.of(this, viewModelFactory).get(TvShowViewModel::class.java)
    }

    private fun loading(){
        progress_bar.visibility = View.GONE
        coordinator.visibility = View.VISIBLE
        FancyToast.makeText(this, getString(R.string.finish_load), FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, false).show()
    }

    private fun loadDataMovie(movie: ItemList?){
        glideMovie("https://image.tmdb.org/t/p/w500${movie?.backdropPath}", iv_big_poster)
        glideMovie("https://image.tmdb.org/t/p/w500${movie?.posterPath}", iv_small_poster)
        tv_score.text = movie?.voteAverage.toString()
        tv_release.text = movie?.releasedDate
        tv_title.text = movie?.title
        if (movie?.tagLine == null)
            tv_tag_line.text = movie?.title
        else
            tv_tag_line.text = movie.tagLine
        tv_overview.text = movie?.overview
    }

    private fun loadDataTvShow(tvShow: TvShowDetail?){
        glideMovie("https://image.tmdb.org/t/p/w500${tvShow?.backdropPath}", iv_big_poster)
        glideMovie("https://image.tmdb.org/t/p/w500${tvShow?.posterPath}", iv_small_poster)
        tv_score.text = tvShow?.voteAverage.toString()
        tv_release.text = tvShow?.firstAirDate
        tv_title.text = tvShow?.name
        tv_tag_line.text = tvShow?.originalName
        tv_overview.text = tvShow?.overview
    }

    private fun glideMovie(url: String, view: ImageView){
        Glide.with(this)
            .load(url)
            .into(view)
    }
}