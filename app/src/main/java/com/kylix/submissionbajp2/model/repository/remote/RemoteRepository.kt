package com.kylix.submissionbajp2.model.repository.remote

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.kylix.submissionbajp2.BuildConfig
import com.kylix.submissionbajp2.network.RetrofitConfig
import com.kylix.submissionbajp2.util.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class RemoteRepository(retrofitConfig: RetrofitConfig) {
    private val apiKey = BuildConfig.API_KEY
    private var handler = Handler(Looper.getMainLooper())
    private val retrofitConfig = RetrofitConfig

    companion object{
        private var INSTANCE: RemoteRepository? = null
        private val TAG = RemoteRepository::class.java.toString()
        private const val TIME_IN_MILLIS: Long = 1500

        fun getInstance(retrofitConfig: RetrofitConfig):RemoteRepository{
            if (INSTANCE == null)
                INSTANCE = RemoteRepository(retrofitConfig)
            return INSTANCE!!
        }
    }

    interface GetMovieCallback{
        fun onResponse(movieResponse: List<ItemList>)
    }

    interface GetMovieDetailCallback{
        fun onResponse(movieDetailResponse: ItemList)
    }

    interface GetTvShowCallback{
        fun onResponse(tvShowResponse: List<ItemList>)
    }

    interface GetTvShowDetailCallback{
        fun onResponse(tvShowDetailResponse: TvShowDetail)
    }

    fun getMovie(getMovieCallback: GetMovieCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            retrofitConfig.create().getMovies(apiKey).enqueue(object: Callback<ItemResponse>{
                override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }

                override fun onResponse(
                    call: Call<ItemResponse>,
                    response: Response<ItemResponse>
                ) {
                    response.body()?.results?.let { getMovieCallback.onResponse(it) }
                    EspressoIdlingResource.decrement()
                }

            })
        }, TIME_IN_MILLIS)
    }

    fun getMovieDetail(movieId: String, getMovieDetailCallback: GetMovieDetailCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            retrofitConfig.create().getMovieDetails(movieId, apiKey).enqueue(object: Callback<ItemList>{
                override fun onFailure(call: Call<ItemList>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }

                override fun onResponse(call: Call<ItemList>, response: Response<ItemList>) {
                    getMovieDetailCallback.onResponse(response.body()!!)
                    EspressoIdlingResource.decrement()
                }

            })
        }, TIME_IN_MILLIS)
    }

    fun getTvShow(getTvShowCallback: GetTvShowCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            retrofitConfig.create().getTvShows(apiKey).enqueue(object: Callback<ItemResponse>{
                override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }

                override fun onResponse(
                    call: Call<ItemResponse>,
                    response: Response<ItemResponse>
                ) {
                    response.body()?.results?.let { getTvShowCallback.onResponse(it) }
                    EspressoIdlingResource.decrement()
                }

            })
        }, TIME_IN_MILLIS)
    }

    fun getTvShowDetail(tvShowId: String, getTvShowDetailCallback: GetTvShowDetailCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            retrofitConfig.create().getTvShowDetails(tvShowId, apiKey).enqueue(object: Callback<TvShowDetail>{
                override fun onFailure(call: Call<TvShowDetail>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }

                override fun onResponse(
                    call: Call<TvShowDetail>,
                    response: Response<TvShowDetail>
                ) {
                    getTvShowDetailCallback.onResponse(response.body()!!)
                    EspressoIdlingResource.decrement()
                }

            })
        }, TIME_IN_MILLIS)
    }
}