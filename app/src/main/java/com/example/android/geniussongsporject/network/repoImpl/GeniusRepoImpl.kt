package com.example.android.geniussongsporject.network.repoImpl

import com.example.android.geniussongsporject.network.data.GeniusResponse
import com.example.android.geniussongsporject.network.endpoint.GeniunsApiEndPoints
import com.example.android.geniussongsporject.network.networkmodel.ServiceResult
import com.example.android.geniussongsporject.network.repo.GeniusRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class GeniusRepoImpl @Inject constructor(
    private val dispatcher: Dispatchers,
    private val retroObject: GeniunsApiEndPoints
    ) : GeniusRepo {
    override suspend fun fetchGeniusSongs(): ServiceResult<GeniusResponse?> {
        return withContext(dispatcher.IO) {
            val dataResponse = retroObject.getSongs()

            if(dataResponse.isSuccessful) {
                ServiceResult.Success(dataResponse.body())
            } else
            {
                ServiceResult.Error(Exception(dataResponse.errorBody().toString()))
            }
        }
    }
}
