package com.kylix.submissionbajp2.model.repository.remote

import com.google.gson.annotations.SerializedName

data class ItemList(
    @SerializedName("id")
    val id: Int,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("tagline")
    val tagLine: String?,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("release_date")
    val releasedDate: String?,

    @SerializedName("vote_average")
    val voteAverage: Double?,

    //Specially title for TvShow
    @SerializedName("name")
    val name: String?
)