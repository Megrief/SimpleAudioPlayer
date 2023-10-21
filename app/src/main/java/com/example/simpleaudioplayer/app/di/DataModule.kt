package com.example.simpleaudioplayer.app.di

import com.example.simpleaudioplayer.data.storage.StorageRepositoryImpl
import com.example.simpleaudioplayer.domain.Track
import com.example.simpleaudioplayer.domain.repository.StorageRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val STORAGE_REPO_TRACK = "StorageRepoTrack"
val dataModule = module {
    single {
        androidContext().contentResolver
    }

    single<StorageRepository<Track?>>(named(STORAGE_REPO_TRACK)) {
        StorageRepositoryImpl(contentResolver = get())
    }
}