package com.kylix.submissionbajp2.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kylix.submissionbajp2.model.repository.DataRepository
import com.kylix.submissionbajp2.model.repository.remote.ItemList

class MovieViewModel(private val dataRepository: DataRepository) : ViewModel() {
    val movie: LiveData<List<ItemList>> = dataRepository.getMovie()
    fun getMovieDetail(movieId: String): LiveData<ItemList> = dataRepository.getMovieDetail(movieId)
}