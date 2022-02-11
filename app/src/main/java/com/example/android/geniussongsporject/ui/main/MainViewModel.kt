package com.example.android.geniussongsporject.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android.geniussongsporject.network.data.GeniusResponse
import com.example.android.geniussongsporject.network.data.Songs
import com.example.android.geniussongsporject.network.networkmodel.ServiceResult
import com.example.android.geniussongsporject.network.repo.GeniusRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val repo: GeniusRepo,
    private val dispatcher: Dispatchers
) : AndroidViewModel(application){

    val _songFeed = MutableLiveData<List<Songs>?>()

    val songFeed: LiveData<List<Songs>?>
        get() = _songFeed

    fun getSongs() {
        viewModelScope.launch(dispatcher.IO) {
            when(val response = repo.fetchGeniusSongs()) {
                is ServiceResult.Success -> {
                    _songFeed.postValue(response.data?.response?.songs)
                    Timber.d("Got the songs baby. " + response.data?.response?.songs)
                }

                is ServiceResult.Error -> {
                    Timber.d("Error was found when calling the songs :: " + response.exception)
                }

                else -> {
                    Timber.d("Bro.")
                }
            }
        }
    }

}
