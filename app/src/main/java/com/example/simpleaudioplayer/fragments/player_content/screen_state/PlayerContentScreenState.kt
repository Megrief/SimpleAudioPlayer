package com.example.simpleaudioplayer.fragments.player_content.screen_state

import com.example.simpleaudioplayer.domain.Track

sealed class PlayerContentScreenState {
    data object Loading : PlayerContentScreenState()

    data object Error : PlayerContentScreenState()

    class Content(val content: List<Track>) : PlayerContentScreenState()

}
