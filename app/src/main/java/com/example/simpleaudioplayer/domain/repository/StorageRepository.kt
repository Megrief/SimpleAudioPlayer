package com.example.simpleaudioplayer.domain.repository

import kotlinx.coroutines.flow.Flow

interface StorageRepository<T> {

    fun getData(): Flow<T>
}