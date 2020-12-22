package com.kylix.submissionbajp2.inject

import com.kylix.submissionbajp2.network.RetrofitConfig
import com.kylix.submissionbajp2.model.repository.DataRepository
import com.kylix.submissionbajp2.model.repository.LocalRepository
import com.kylix.submissionbajp2.model.repository.remote.RemoteRepository

object Injection {
    fun movieRepository(): DataRepository{
        val localRepository = LocalRepository()
        val remoteRepository = RemoteRepository.getInstance(RetrofitConfig)
        return DataRepository.getInstance(localRepository, remoteRepository)!!
    }
}