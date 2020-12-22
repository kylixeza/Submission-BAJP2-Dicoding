package com.kylix.submissionbajp2.network

import com.kylix.submissionbajp2.model.repository.remote.ItemList
import com.kylix.submissionbajp2.model.repository.remote.ItemResponse
import com.kylix.submissionbajp2.model.repository.remote.TvShowDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {

    @GET("movie/popular")
    fun getMovies(@Query("api_key") apiKey: String): Call<ItemResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId: String?,
                        @Query("api_key") apiKey: String?
    ) : Call<ItemList>

    @GET("tv/popular")
    fun getTvShows(@Query("api_key") apiKey: String?) : Call<ItemResponse>


    @GET("tv/{tv_id}")
    fun getTvShowDetails(@Path("tv_id") tvId: String?,
                         @Query("api_key") apiKey: String?
    ) : Call<TvShowDetail>
}