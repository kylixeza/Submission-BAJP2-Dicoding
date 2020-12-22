package com.kylix.submissionbajp2.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kylix.submissionbajp2.inject.Injection
import com.kylix.submissionbajp2.model.repository.DataRepository
import com.kylix.submissionbajp2.ui.movie.MovieViewModel
import com.kylix.submissionbajp2.ui.tvshow.TvShowViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val dataRepository: DataRepository): ViewModelProvider.NewInstanceFactory() {
    companion object{
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory? {
            if (INSTANCE == null){
                synchronized(ViewModelFactory::class.java){
                    if (INSTANCE == null)
                        INSTANCE = ViewModelFactory(Injection.movieRepository())
                }
            }
            return INSTANCE
        }
    }


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(dataRepository) as T
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> TvShowViewModel(dataRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel: " + modelClass.name)
        }
    }
}