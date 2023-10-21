package com.example.simpleaudioplayer.domain.use_cases_impl

import com.example.simpleaudioplayer.domain.Track
import com.example.simpleaudioplayer.domain.repository.StorageRepository
import com.example.simpleaudioplayer.domain.use_cases.GetDataUseCase
import kotlinx.coroutines.flow.Flow

class GetTrackUseCaseImpl(private val repository: StorageRepository<Track?>) : GetDataUseCase<Track?> {
    override fun get(): Flow<Track?> = repository.getData()
}