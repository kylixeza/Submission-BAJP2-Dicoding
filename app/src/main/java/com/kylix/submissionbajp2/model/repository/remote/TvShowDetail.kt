package com.kylix.submissionbajp2.model.repository.remote

import com.google.gson.annotations.SerializedName

data class TvShowDetail (
        @SerializedName("id")
        val id: Int,

        @SerializedName("poster_path")
        val posterPath: String?,

        @SerializedName("backdrop_path")
        val backdropPath: String?,

        @SerializedName("name")
        val name: String?,

        @SerializedName("original_name")
        val originalName: String?,

        @SerializedName("first_air_date")
        val firstAirDate: String?,

        @SerializedName("overview")
        val overview: String?,

        @SerializedName("vote_average")
        val voteAverage: Double?
)