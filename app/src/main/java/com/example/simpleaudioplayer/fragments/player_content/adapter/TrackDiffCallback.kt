package com.example.simpleaudioplayer.fragments.player_content.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.simpleaudioplayer.domain.Track

class TrackDiffCallback(private val oldList: List<Track>, private val newList: List<Track>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] === newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}