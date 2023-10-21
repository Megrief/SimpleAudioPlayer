package com.example.simpleaudioplayer.app.di

import com.example.simpleaudioplayer.fragments.player_content.view_model.PlayerContentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        PlayerContentViewModel(
            getDataUseCase = get(named(GET_TRACK_USE_CASE))
        )
    }
}