package com.example.simpleaudioplayer.domain.use_cases

import com.example.simpleaudioplayer.domain.Track
import kotlinx.coroutines.flow.Flow

interface GetDataUseCase<T> {

    fun get(): Flow<T>
}