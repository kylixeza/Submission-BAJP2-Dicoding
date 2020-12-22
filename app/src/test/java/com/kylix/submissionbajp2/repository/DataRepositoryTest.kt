package com.kylix.submissionbajp2.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kylix.submissionbajp2.FakeData
import com.kylix.submissionbajp2.LiveDataTest
import com.kylix.submissionbajp2.model.repository.LocalRepository
import com.kylix.submissionbajp2.model.repository.remote.RemoteRepository
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class DataRepositoryTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val localRepository = mock(LocalRepository::class.java)
    private val remoteRepository = mock(RemoteRepository::class.java)
    private val dataRepositoryTest = FakeDataRepository(localRepository, remoteRepository)

    private val movieList = FakeData.getDummyRemoteMovie()
    private val movieId = FakeData.getDummyRemoteMovie()[0].id.toString()
    private val tvShowList = FakeData.getDummyRemoteTvShows()
    private val tvShowId = tvShowList[0].id.toString()
    private val tvShowDetail = FakeData.getTvShowDetail()

    private fun <T> anyOfT(type: Class<T>): T = any(type)

    private fun <T> eqOfT(obj: T): T = eq(obj)


    @Test
    fun getMovieDetail() {
        doAnswer {
            val callback = it.arguments[0] as RemoteRepository.GetMovieDetailCallback
            callback.onResponse(movieList[0])
            null
        }.`when`(remoteRepository).getMovieDetail(
            eqOfT(movieId),
            anyOfT(RemoteRepository.GetMovieDetailCallback::class.java))

//        val result = LiveDataTest.getValue(dataRepositoryTest.getMovieDetail(eqOfT(tvShowId)))
//        verify(remoteRepository).getMovieDetail(eqOfT(tvShowId)
//        , anyOfT(RemoteRepository.GetMovieDetailCallback::class.java))
//       assertEquals(movieId, result)
    }

    @Test
    fun getTvShowDetail() {
        doAnswer {
            val callback = it.arguments[0] as RemoteRepository.GetTvShowDetailCallback
            callback.onResponse(tvShowDetail)
            null
        }.`when`(remoteRepository).getTvShowDetail(eqOfT(tvShowId),
            anyOfT(RemoteRepository.GetTvShowDetailCallback::class.java))

//        val result = LiveDataTest.getValue(dataRepositoryTest.getTvShowDetail(eqOfT(tvShowId)))
//        verify(remoteRepository).getTvShowDetail(eqOfT(tvShowId),
//            anyOfT(RemoteRepository.GetTvShowDetailCallback::class.java))
//       assertEquals(tvShowId, result)
    }

    @Test
    fun getMovie() {
        doAnswer {
            val callback = it.arguments[0] as RemoteRepository.GetMovieCallback
            callback.onResponse(movieList)
            null
        }.`when`(remoteRepository).getMovie(anyOfT(RemoteRepository.GetMovieCallback::class.java))

        val result = LiveDataTest.getValue(dataRepositoryTest.getMovie())
//         verify(remoteRepository).getMovie(any(RemoteRepository.GetMovieCallback::class.java))
        assertEquals(movieList.size, result.size)
    }

    @Test
    fun getTvShow() {
        doAnswer {
            val callback = it.arguments[0] as RemoteRepository.GetTvShowCallback
            callback.onResponse(tvShowList)
            null
        }.`when`(remoteRepository).getTvShow(anyOfT(RemoteRepository.GetTvShowCallback::class.java))

        val result = LiveDataTest.getValue(dataRepositoryTest.getTvShow())
//        verify(remoteRepository).getTvShow(any(RemoteRepository.GetTvShowCallback::class.java))
        assertEquals(tvShowList.size, result.size)
    }
}