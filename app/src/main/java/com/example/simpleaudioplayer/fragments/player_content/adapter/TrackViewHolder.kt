package com.example.simpleaudioplayer.fragments.player_content.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.simpleaudioplayer.databinding.TrackCardBinding
import com.example.simpleaudioplayer.domain.Track

class TrackViewHolder(private val binding: TrackCardBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(track: Track) {
        with(binding) {
            tracksName.text = track.name
            artistsName.text = track.artist
        }
    }
}