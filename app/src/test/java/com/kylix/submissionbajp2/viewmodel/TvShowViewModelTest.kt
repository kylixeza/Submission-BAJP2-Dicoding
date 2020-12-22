package com.kylix.submissionbajp2.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.kylix.submissionbajp2.FakeData
import com.kylix.submissionbajp2.model.repository.DataRepository
import com.kylix.submissionbajp2.model.repository.remote.ItemList
import com.kylix.submissionbajp2.model.repository.remote.TvShowDetail
import com.kylix.submissionbajp2.ui.tvshow.TvShowViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class TvShowViewModelTest {
    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var viewModel: TvShowViewModel? = null
    private var data = Mockito.mock(DataRepository::class.java)

    @Before
    fun setUp(){
        viewModel = TvShowViewModel(data)
    }

    @Test
    fun getTvShowList(){
        val tvShow = MutableLiveData<List<ItemList>>()
        tvShow.value = FakeData.getDummyRemoteMovie()
        Mockito.`when`(data.getTvShow()).thenReturn(tvShow)
        val observer = Mockito.mock(Observer::class.java)
        viewModel?.tvShow?.observeForever(observer as Observer<List<ItemList>>)
        Mockito.verify(data).getTvShow()
    }

    @Test
    fun getTvShowDetail(){
        val tvShow = MutableLiveData<TvShowDetail>()
        tvShow.value = FakeData.getTvShowDetail()
        Mockito.`when`(data.getTvShowDetail(tvShow.value!!.id.toString())).thenReturn(tvShow)
        val observer = Mockito.mock(Observer::class.java)
        viewModel?.getTvShowDetail(tvShow.value!!.id.toString())?.observeForever(observer as Observer<TvShowDetail>)
        Mockito.verify(data).getTvShow()

        Assert.assertEquals(tvShow.value!!.id, viewModel?.getTvShowDetail(tvShow.value!!.id.toString())?.value?.id)
        Assert.assertEquals(tvShow.value!!.name, viewModel?.getTvShowDetail(tvShow.value!!.id.toString())?.value?.name)
        Assert.assertEquals(tvShow.value!!.overview, viewModel?.getTvShowDetail(tvShow.value!!.id.toString())?.value?.overview)
        Assert.assertEquals(tvShow.value!!.posterPath, viewModel?.getTvShowDetail(tvShow.value!!.id.toString())?.value?.posterPath)
        Assert.assertEquals(tvShow.value!!.firstAirDate, viewModel?.getTvShowDetail(tvShow.value!!.id.toString())?.value?.firstAirDate)
    }
}