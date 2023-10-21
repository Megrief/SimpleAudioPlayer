package com.example.simpleaudioplayer.data.storage

import android.content.ContentResolver
import android.content.ContentUris
import android.net.Uri
import android.provider.MediaStore.Audio.Media
import com.example.simpleaudioplayer.domain.Track
import com.example.simpleaudioplayer.domain.repository.StorageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StorageRepositoryImpl(
    private val contentResolver: ContentResolver
) : StorageRepository<Track?> {

    override fun getData(): Flow<Track?> = flow {
        val cursor = contentResolver
            .query(Media.EXTERNAL_CONTENT_URI, projection, null, null, null)
        if (cursor != null && cursor.moveToFirst()) {

            val id = cursor.getColumnIndex(Media._ID)
            val name = cursor.getColumnIndex(Media.DISPLAY_NAME)
            val artist = cursor.getColumnIndex(Media.ARTIST)
            val trackId = cursor.getLong(id)

            do {
                emit(
                    Track(
                        id = trackId,
                        name = cursor.getString(name),
                        artist = cursor.getString(artist),
                        uri = getUriById(trackId)
                    )
                )
            } while (cursor.moveToNext())
            cursor.close()
        } else emit(null)
    }

    private fun getUriById(id: Long): Uri {
        return ContentUris.withAppendedId(Media.EXTERNAL_CONTENT_URI, id)
    }

    companion object {
        private val projection = arrayOf(
            Media._ID,
            Media.DISPLAY_NAME,
            Media.ARTIST
        )
    }
}