package com.example.android.geniussongsporject.network.repo

import com.example.android.geniussongsporject.network.data.GeniusResponse
import com.example.android.geniussongsporject.network.networkmodel.ServiceResult

interface GeniusRepo {
    suspend fun fetchGeniusSongs()
    : ServiceResult<GeniusResponse?>
}
