package com.example.android.geniussongsporject.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.geniussongsporject.databinding.ListItemGeniusSongBinding
import com.example.android.geniussongsporject.network.data.Songs

class MainAdapter: ListAdapter<Songs, MainAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private var binding: ListItemGeniusSongBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(song: Songs) {
            binding.song = song
            binding.executePendingBindings()

            binding.songBackground.setOnClickListener { v: View ->
                v.findNavController().navigate(
                    MainFragmentDirections.actionMainFragmentToSongInfoFragment(
                        song = song
                    )
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemGeniusSongBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val songFeed = getItem(position)
        holder.bind(songFeed)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Songs>() {
        override fun areItemsTheSame(oldItem: Songs, newItem: Songs): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Songs, newItem: Songs): Boolean {
            return oldItem.title == newItem.title
        }
    }


}
