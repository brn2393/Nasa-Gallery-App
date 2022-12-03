package com.obvious.nasagalleryapp.domain.repositories

import com.obvious.nasagalleryapp.domain.base.BaseRepository
import com.obvious.nasagalleryapp.domain.models.NasaMetadata
import javax.inject.Inject

class ImageDetailsRepository @Inject constructor() : BaseRepository() {

    suspend fun getImageMetadata(): NasaMetadata {
        return NasaMetadata("")
    }
}