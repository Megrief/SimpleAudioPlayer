package com.example.simpleaudioplayer.app.di

import com.example.simpleaudioplayer.domain.Track
import com.example.simpleaudioplayer.domain.use_cases.GetDataUseCase
import com.example.simpleaudioplayer.domain.use_cases_impl.GetTrackUseCaseImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val GET_TRACK_USE_CASE = "GetTrackUseCase"
val domainModule = module {
    factory<GetDataUseCase<Track?>>(named(GET_TRACK_USE_CASE)) {
        GetTrackUseCaseImpl(repository = get(named(STORAGE_REPO_TRACK)))
    }

}