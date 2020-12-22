package com.kylix.submissionbajp2.model.source

import androidx.lifecycle.LiveData
import com.kylix.submissionbajp2.model.repository.remote.ItemList
import com.kylix.submissionbajp2.model.repository.remote.TvShowDetail

interface DataSource {
    fun getMovie(): LiveData<List<ItemList>>
    fun getMovieDetail(movieId: String): LiveData<ItemList>
    fun getTvShow(): LiveData<List<ItemList>>
    fun getTvShowDetail(tvShowId: String): LiveData<TvShowDetail>
}