package com.example.android.geniussongsporject.ui.songinfo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.android.geniussongsporject.network.data.Songs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SongInfoViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application)
{
    lateinit var song: Songs
}
