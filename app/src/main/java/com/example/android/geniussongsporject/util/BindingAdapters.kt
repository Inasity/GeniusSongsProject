package com.example.android.geniussongsporject.util

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android.geniussongsporject.R
import com.example.android.geniussongsporject.network.data.GeniusResponse
import com.example.android.geniussongsporject.network.data.Songs
import com.example.android.geniussongsporject.ui.main.MainAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    if(imgUrl != null)
    {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https")?.build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
            .override(450, 450)
            .fitCenter())
            .into(imgView)
    }
    else
    {
        Glide.with(imgView.context)
            .load(R.drawable.error_image)
            .apply(RequestOptions()
                .override(450, 450)
                .fitCenter())
            .into(imgView)
    }
}

@BindingAdapter("listGeniusSongs")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Songs>?) {
    val adapter = recyclerView.adapter as MainAdapter
    adapter.submitList(data)
}
