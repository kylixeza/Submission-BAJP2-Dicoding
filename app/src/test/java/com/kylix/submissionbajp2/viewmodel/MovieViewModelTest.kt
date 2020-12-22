package com.kylix.submissionbajp2.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.kylix.submissionbajp2.FakeData
import com.kylix.submissionbajp2.model.repository.DataRepository
import com.kylix.submissionbajp2.model.repository.remote.ItemList
import com.kylix.submissionbajp2.ui.movie.MovieViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MovieViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var viewModel: MovieViewModel? = null
    private var data = Mockito.mock(DataRepository::class.java)

    @Before
    fun setUp(){
        viewModel = MovieViewModel(data)
    }

    @Test
    fun getMovieList(){
        val movie = MutableLiveData<List<ItemList>>()
        movie.value = FakeData.getDummyRemoteMovie()
        Mockito.`when`(data.getMovie()).thenReturn(movie)
        val observer = Mockito.mock(Observer::class.java)
        viewModel?.movie?.observeForever(observer as Observer<List<ItemList>>)
        Mockito.verify(data).getMovie()
    }

    @Test
    fun getMovieDetail(){
        val movie = MutableLiveData<ItemList>()
        movie.value = FakeData.getDummyRemoteMovie()[0]
        Mockito.`when`(data.getMovieDetail(movie.value!!.id.toString())).thenReturn(movie)
        val observer = Mockito.mock(Observer::class.java)
        viewModel?.getMovieDetail(movie.value!!.id.toString())?.observeForever(observer as Observer<ItemList>)
        Mockito.verify(data).getMovie()

        assertEquals(movie.value!!.id, viewModel?.getMovieDetail(movie.value!!.id.toString())?.value?.id)
        assertEquals(movie.value!!.title, viewModel?.getMovieDetail(movie.value!!.id.toString())?.value?.title)
        assertEquals(movie.value!!.tagLine, viewModel?.getMovieDetail(movie.value!!.id.toString())?.value?.tagLine)
        assertEquals(movie.value!!.overview, viewModel?.getMovieDetail(movie.value!!.id.toString())?.value?.overview)
        assertEquals(movie.value!!.posterPath, viewModel?.getMovieDetail(movie.value!!.id.toString())?.value?.posterPath)
        assertEquals(movie.value!!.releasedDate, viewModel?.getMovieDetail(movie.value!!.id.toString())?.value?.releasedDate)
    }
}