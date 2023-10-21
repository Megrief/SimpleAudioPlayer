package com.example.simpleaudioplayer.fragments.player_content.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleaudioplayer.databinding.TrackCardBinding
import com.example.simpleaudioplayer.domain.Track

class TrackAdapter(private val contentUris: List<Track> = emptyList()) : RecyclerView.Adapter<TrackViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val binding = TrackCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return TrackViewHolder(binding)
    }

    override fun getItemCount(): Int = contentUris.size

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(contentUris[position])
        holder.itemView.setOnClickListener { Log.d("D", "On track clicked") }
    }

    fun setListContent(newList: List<Track>) {

    }
}