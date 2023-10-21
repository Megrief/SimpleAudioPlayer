package com.example.simpleaudioplayer.fragments.player_content.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleaudioplayer.domain.Track
import com.example.simpleaudioplayer.domain.use_cases.GetDataUseCase
import com.example.simpleaudioplayer.fragments.player_content.screen_state.PlayerContentScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerContentViewModel(
    private val getDataUseCase: GetDataUseCase<Track?>
) : ViewModel() {

    private val _screenState: MutableLiveData<PlayerContentScreenState> =
        MutableLiveData<PlayerContentScreenState>(PlayerContentScreenState.Loading)
    val screenState: LiveData<PlayerContentScreenState>
        get() = _screenState

    init {
        val content = mutableListOf<Track>()
        viewModelScope.launch(Dispatchers.IO) {
            getDataUseCase.get().collect { track ->
                if (track != null) content.add(track)
            }
            _screenState.postValue(PlayerContentScreenState.Content(content))
        }
    }
}
