package com.example.android.geniussongsporject.network.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GeniusResponse (

    val meta     : Meta?     = Meta(),
    val response : Response?

): Parcelable

@Parcelize
data class Meta (

    val status : Int? = null

) : Parcelable

@Parcelize
data class PrimaryArtist (

    @SerializedName("api_path"         ) val apiPath        : String?,
    @SerializedName("header_image_url" ) val headerImageUrl : String?,
    val id             : Int,
    @SerializedName("image_url"        ) val imageUrl       : String?,
    @SerializedName("is_meme_verified" ) val isMemeVerified : Boolean?,
    @SerializedName("is_verified"      ) val isVerified     : Boolean?,
    val name           : String?,
    val url            : String?

): Parcelable

@Parcelize
data class Songs (

    @SerializedName("annotation_count"             ) var annotationCount          : Int?,
    @SerializedName("api_path"                     ) var apiPath                  : String?,
    @SerializedName("artist_names"                 ) var artistNames              : String?,
    @SerializedName("full_title"                   ) var fullTitle                : String?,
    @SerializedName("header_image_thumbnail_url"   ) var headerImageThumbnailUrl  : String?,
    @SerializedName("header_image_url"             ) var headerImageUrl           : String?,
    @SerializedName("id"                           ) var id                       : Int,
    @SerializedName("lyrics_owner_id"              ) var lyricsOwnerId            : Int?,
    @SerializedName("lyrics_state"                 ) var lyricsState              : String?,
    @SerializedName("path"                         ) var path                     : String?,
    @SerializedName("pyongs_count"                 ) var pyongsCount              : Int?,
    @SerializedName("song_art_image_thumbnail_url" ) var songArtImageThumbnailUrl : String?,
    @SerializedName("song_art_image_url"           ) var songArtImageUrl          : String?,
    @SerializedName("title"                        ) var title                    : String?,
    @SerializedName("title_with_featured"          ) var titleWithFeatured        : String?,
    @SerializedName("url"                          ) var url                      : String?,
    @SerializedName("primary_artist"               ) var primaryArtist            : PrimaryArtist?

): Parcelable

@Parcelize
data class Response (

    @SerializedName("songs"     ) var songs    : List<Songs>?,
    @SerializedName("next_page" ) var nextPage : Int?             = null

): Parcelable
