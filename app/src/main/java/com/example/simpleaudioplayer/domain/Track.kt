package com.example.simpleaudioplayer.domain

import android.net.Uri

data class Track(
    val id: Long,
    val name: String,
    val artist: String,
    val uri: Uri
)