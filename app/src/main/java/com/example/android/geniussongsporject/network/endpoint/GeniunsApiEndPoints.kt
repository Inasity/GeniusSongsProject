package com.example.android.geniussongsporject.network.endpoint

import com.example.android.geniussongsporject.network.data.GeniusResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface GeniunsApiEndPoints {
    @GET("/artists/16775/songs")
    suspend fun getSongs(
        @Header("x-rapidapi-host") host: String = "genius.p.rapidapi.com",
        @Header("x-rapidapi-key") key: String = "4291a61388msh1f5b018fde8a27bp16e251jsn494b88af4524",

    ): Response<GeniusResponse>
}
