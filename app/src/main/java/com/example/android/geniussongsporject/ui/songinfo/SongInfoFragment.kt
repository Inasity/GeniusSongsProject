package com.example.android.geniussongsporject.ui.songinfo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.android.geniussongsporject.R
import com.example.android.geniussongsporject.databinding.SongInfoFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SongInfoFragment : Fragment() {

    private val songParamsFragmentArgs by navArgs<SongInfoFragmentArgs>()

    private val viewModel: SongInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.song = songParamsFragmentArgs.song

        val binding = SongInfoFragmentBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        return binding.root
    }

}
