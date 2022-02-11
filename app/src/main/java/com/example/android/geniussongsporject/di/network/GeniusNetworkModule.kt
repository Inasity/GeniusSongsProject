package com.example.android.geniussongsporject.di.network

import com.example.android.geniussongsporject.network.endpoint.GeniunsApiEndPoints
import com.example.android.geniussongsporject.network.repo.GeniusRepo
import com.example.android.geniussongsporject.network.repoImpl.GeniusRepoImpl
import com.example.android.geniussongsporject.network.retrofit.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object GeniusNetworkModule {
    private const val GeniusBaseUrl = "https://genius.p.rapidapi.com/"

    @Singleton
    @Provides
    fun provideGeniusRetrofit(): GeniunsApiEndPoints {
        return RetrofitFactory.retrofitProvider(
            GeniunsApiEndPoints::class.java,
            GeniusBaseUrl
        )
    }

    @Singleton
    @Provides
    fun provideGeniusRepo(
        dispatcher: Dispatchers,
        retroObject: GeniunsApiEndPoints
    ): GeniusRepo {
        return GeniusRepoImpl(dispatcher, retroObject)
    }
}
