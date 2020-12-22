package com.kylix.submissionbajp2.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kylix.submissionbajp2.model.repository.DataRepository
import com.kylix.submissionbajp2.model.repository.remote.ItemList
import com.kylix.submissionbajp2.model.repository.remote.TvShowDetail

class TvShowViewModel(private val dataRepository: DataRepository) : ViewModel() {
    val tvShow: LiveData<List<ItemList>> = dataRepository.getTvShow()
    fun getTvShowDetail(tvId: String): LiveData<TvShowDetail> = dataRepository.getTvShowDetail(tvId)
}